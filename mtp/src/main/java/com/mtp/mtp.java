/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp;

import com.google.common.eventbus.EventBus;
import com.mtp.DbConnectionPool.DbProperties;
import com.mtp.abstraction.E2EAbstractionLogic;
import com.mtp.abstraction.ResourceSelectionLogic;
import com.mtp.common.DatabaseDriver;
import com.mtp.events.abstraction.Creation.ParseFederatedPopList;
import com.mtp.extinterface.sbi.SBIIF;
import com.mtp.resourcemanagement.ResouceOrchestration;
//import java.lang.String;
import com.mtp.events.abstraction.Creation.Parsedomainlist;
import com.mtp.events.abstraction.Creation.StartServer;
import com.mtp.events.abstraction.Creation.StopServer;
import com.mtp.extinterface.mon.MonitoringIF;
import com.mtp.extinterface.nbi.swagger.api.AbstractComputeResourcesApi;
import com.mtp.extinterface.nbi.swagger.api.AbstractFederatedResourcesApi;
import com.mtp.extinterface.nbi.swagger.api.AbstractNetworkResourcesApi;
import com.mtp.extinterface.nbi.swagger.api.AbstractResourcesApi;
import com.mtp.extinterface.nbi.swagger.api.MecappApi;
import com.mtp.extinterface.nbi.swagger.api.NBIIF;
import com.mtp.extinterface.nbi.swagger.api.NetworkResourcesApi;
import com.mtp.extinterface.pa.PlacementIF;
import com.mtp.monitoring.MonitoringDriver;
import com.mtp.placement.PlacementDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.ibatis.jdbc.ScriptRunner;

//import com.mtp.DeadEventListener;
/**
 * @author user
 */
public class mtp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        boolean onexit = false;
        boolean stub_en = true; //enable stubmode
        Scanner scanner = new Scanner(System.in);
        String prompt;
        //Create eventbus
        System.out.println("MTP START");
        EventBus evbus;
        DbProperties dbPropertires = DbProperties.getInstance();
        NBIIF soif = new NBIIF(args[1], args[2]);
        evbus = SingletonEventBus.getBus();

        //see if STUB_MODE is set as properties
        String stubmode;
        stubmode = System.getProperty("STUB_ENABLE");

        if ((stubmode == null) || (!stubmode.equals("yes"))) {
            //Execute MTP using IFA005 as SBI
            System.out.println("///////STUB MODE DISABLE /////////");
            stub_en = false;
        } else {
            System.out.println("///////STUB MODE ENABLE /////////");
        }

        //see if autoManagementReverseLL is set as properties
        boolean autoManagementReverseLL = true;
        String autoManagement;
        autoManagement = System.getProperty("AUTO_MANAGEMENT_LL");

        if ((autoManagement == null) || (!autoManagement.equals("yes"))) {
            //Execute MTP using IFA005 as SBI
            System.out.println("///////AUTO MANAGEMENT REVERSE LL DISABLE /////////");
            autoManagementReverseLL = false;
        } else {
            System.out.println("///////AUTO MANAGEMENT REVERSE LL ENABLE /////////");
        }

        //DROP ALL TABLES FROM DB
//SCRIPT PATH
        String aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "utility", "mtpdb_drop.sql").toString();

// String aSQLScriptFilePath = "..\\dbscripts\\utility\\mtpdb_drop.sql";
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtpdomdb?allowPublicKeyRetrieval=true&useSSL=false", "mtp", "mtp");
        Connection con = DriverManager.getConnection(dbPropertires.getProperty("DbMainURL"), dbPropertires.getProperty("DbMainUsername"), dbPropertires.getProperty("DbMainPassword"));
        try {
            // Initialize object for ScripRunner
            ScriptRunner sr = new ScriptRunner(con);
            // Give the input file to Reader
            Reader reader = new BufferedReader(
                    new FileReader(aSQLScriptFilePath));
            // Exctute script
            sr.runScript(reader);
        } catch (Exception e) {
            System.err.println("Failed to Execute" + aSQLScriptFilePath
                    + " The error is " + e.getMessage());
        }

        if (stub_en == true) {
            aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "test_topology", "Dump.sql").toString();
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con);
                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(aSQLScriptFilePath));
                // Exctute script
                sr.runScript(reader);
            } catch (Exception e) {
                System.err.println("Failed to Execute" + aSQLScriptFilePath
                        + " The error is " + e.getMessage());
            }

        }

        //CREATE DB SCHEME
//SCRIPT PATH
        if (stub_en == false) {
            aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "mtpscheme.sql").toString();
            //     aSQLScriptFilePath = "..\\dbscripts\\mtpscheme.sql";
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtpdomdb?allowPublicKeyRetrieval=true&useSSL=false", "mtp", "mtp");
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "mtp", "mtp");
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con);
                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(aSQLScriptFilePath));
                // Exctute script
                sr.runScript(reader);
            } catch (Exception e) {
                System.err.println("Failed to Execute" + aSQLScriptFilePath
                        + " The error is " + e.getMessage());
            }
        }

        //INSERT INTER_DOMAIN_LINKS into DB
//SCRIPT PATH
        if (stub_en == false) {
            aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "test_topology", "interdomainlinks.sql").toString();
// aSQLScriptFilePath = "..\\dbscripts\\test_topology\\interdomainlinks.sql";
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtpdomdb?allowPublicKeyRetrieval=true&useSSL=false", "mtp", "mtp");
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "mtp", "mtp");
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con);
                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(aSQLScriptFilePath));
                // Exctute script
                sr.runScript(reader);
            } catch (Exception e) {
                System.err.println("Failed to Execute" + aSQLScriptFilePath
                        + " The error is " + e.getMessage());
            }
        }
        //INSERT FEDERATED INTER_DOMAIN_LINKS into DB
//SCRIPT PATH
        if (stub_en == false) {
            aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "test_topology", "fed_interdomainlinks.sql").toString();
// aSQLScriptFilePath = "..\\dbscripts\\test_topology\\interdomainlinks.sql";
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtpdomdb?allowPublicKeyRetrieval=true&useSSL=false", "mtp", "mtp");
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "mtp", "mtp");
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con);
                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(aSQLScriptFilePath));
                // Exctute script
                sr.runScript(reader);
            } catch (Exception e) {
                System.err.println("Failed to Execute" + aSQLScriptFilePath
                        + " The error is " + e.getMessage());
            }
        }

        //INSERT MEC APPD into DB
//SCRIPT PATH
        if (stub_en == false) {
            aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "test_topology", "appdlist.sql").toString();
// aSQLScriptFilePath = "..\\dbscripts\\test_topology\\computeFlavour.sql";
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtpdomdb?allowPublicKeyRetrieval=true&useSSL=false", "mtp", "mtp");
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "mtp", "mtp");
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con);
                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(aSQLScriptFilePath));
                // Exctute script
                sr.runScript(reader);
            } catch (Exception e) {
                System.err.println("Failed to Execute" + aSQLScriptFilePath
                        + " The error is " + e.getMessage());
            }
        }

        if (stub_en == false) {
            //INSERT COMPUTE_FALVOURS into DB        
//SCRIPT PATH

            aSQLScriptFilePath = java.nio.file.Paths.get("..", "dbscripts", "test_topology", "computeFlavour.sql").toString();
// aSQLScriptFilePath = "..\\dbscripts\\test_topology\\computeFlavour.sql";
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtpdomdb?allowPublicKeyRetrieval=true&useSSL=false", "mtp", "mtp");
            // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "mtp", "mtp");
            try {
                // Initialize object for ScripRunner
                ScriptRunner sr = new ScriptRunner(con);
                // Give the input file to Reader
                Reader reader = new BufferedReader(
                        new FileReader(aSQLScriptFilePath));
                // Exctute script
                sr.runScript(reader);
            } catch (Exception e) {
                System.err.println("Failed to Execute" + aSQLScriptFilePath
                        + " The error is " + e.getMessage());
            }
        }
        //register all modules
        System.out.println("MTP registering modules ...");
        evbus.register(new E2EAbstractionLogic());
        evbus.register(new ResourceSelectionLogic());
        evbus.register(new DatabaseDriver());
        evbus.register(soif);
        evbus.register(new SBIIF(stub_en));
        evbus.register(new ResouceOrchestration());
        //register jaxrs api
//        evbus.register(new ComputeResourcesApi());
//        evbus.register(new HealthzApi());
//        evbus.register(new InformationApi());
        evbus.register(new NetworkResourcesApi());
//        evbus.register(new QuotasApi());
//        evbus.register(new ReservationsApi());
//        evbus.register(new SoftwareImagesApi());
        evbus.register(new AbstractComputeResourcesApi());

//        AbstractNetworkResourcesApi abstrNetResApi = new AbstractNetworkResourcesApi();
//        // Set autoManagementReverseLL property
//        abstrNetResApi.setAutoManagementReverseLL(autoManagementReverseLL);
//        evbus.register(abstrNetResApi);
        
        
evbus.register(new AbstractNetworkResourcesApi());
        evbus.register(new AbstractResourcesApi());
        evbus.register(new AbstractFederatedResourcesApi());
        evbus.register(new MecappApi());
        evbus.register(new PlacementDriver());
        evbus.register(new PlacementIF());
        evbus.register(new MonitoringDriver());
        evbus.register(new MonitoringIF());

        //class to register dead event
        evbus.register(new DeadEventListener());
        //register deadevent for debug
        System.out.println("Done !!!");

        if (stub_en == false) {
            /**
             * ******************************************
             * FEDERATION
             */
            System.out.println("Start acquiring abstract domain info... !!!");
            String federationfile = "../xml_domain/federatedResources.xml";
            ParseFederatedPopList federated_pop_list = new ParseFederatedPopList(federationfile);
            evbus.post(federated_pop_list);

            /**
             * ******************************************
             * FEDERATION
             */
        }
        if (stub_en == false) {
            System.out.println("Start acquiring abstract domain info... !!!");
            String domfile = args[0];
            Parsedomainlist domlist = new Parsedomainlist(domfile);
            evbus.post(domlist);
        }

        if (stub_en == true) {
            StartServer servreq = new StartServer();
            SingletonEventBus.getBus().post(servreq);
            System.out.println("DatabaseDriver ---> Start Server http");
        }

        //System.out.println("MTP ready ");
        System.out.println("Start MTP feature TEST:");
        while (!onexit) {

            System.out.println("-- Type EXIT to exit the program:");

            prompt = scanner.next();
            if (prompt.equals("EXIT")) {
                StopServer servreq = new StopServer();
                evbus.post(servreq);
                onexit = true;
                continue;
            }

        }

    }
}
