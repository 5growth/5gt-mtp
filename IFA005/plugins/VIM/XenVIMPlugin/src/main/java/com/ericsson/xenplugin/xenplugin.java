/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.xenplugin;

import com.ericsson.xenplugin.events.abstraction.Parsedomainlist;
import com.ericsson.xenplugin.events.abstraction.StopServer;
import com.ericsson.xenplugin.nbi.swagger.api.ComputeResourcesApi;
import com.ericsson.xenplugin.nbi.swagger.api.HealthzApi;
import com.ericsson.xenplugin.nbi.swagger.api.InformationApi;
import com.ericsson.xenplugin.nbi.swagger.api.MTPIF;
import com.ericsson.xenplugin.nbi.swagger.api.NetworkResourcesApi;
import com.ericsson.xenplugin.nbi.swagger.api.QuotasApi;
import com.ericsson.xenplugin.nbi.swagger.api.ReservationsApi;
import com.ericsson.xenplugin.nbi.swagger.api.SoftwareImagesApi;
import com.ericsson.xenplugin.sbi.XenIF;
import com.google.common.eventbus.EventBus;
//import com.mtp.abstraction.E2EAbstractionLogic;
//import com.mtp.abstraction.ResourceSelectionLogic;
//import com.mtp.common.DatabaseDriver;
//import com.mtp.extinterface.sbi.SBIIF;
//import com.mtp.resourcemanagement.ResouceOrchestration;
////import java.lang.String;
//import com.mtp.events.abstraction.Creation.Parsedomainlist;
//import com.mtp.events.abstraction.Creation.StopServer;
//import com.mtp.extinterface.nbi.swagger.api.ComputeResourcesApi;
//import com.mtp.extinterface.nbi.swagger.api.HealthzApi;
//import com.mtp.extinterface.nbi.swagger.api.InformationApi;
//import com.mtp.extinterface.nbi.swagger.api.NBIIF;
//import com.mtp.extinterface.nbi.swagger.api.NetworkResourcesApi;
//import com.mtp.extinterface.nbi.swagger.api.QuotasApi;
//import com.mtp.extinterface.nbi.swagger.api.ReservationsApi;
//import com.mtp.extinterface.nbi.swagger.api.SoftwareImagesApi;
import java.util.Scanner;
//import com.eranplugin.DeadEventListener;
/**
 *
 * @author user
 */
public class xenplugin {
    public static void main(String[] args) {
        boolean onexit = false;
        boolean stub_en = true; //enable stubmode
        Scanner scanner = new Scanner(System.in);
        String prompt;
        //Create eventbus
        System.out.println("XEN PLUGIN START");
        EventBus evbus;
        MTPIF mtpif = new MTPIF(args[1], args[2]);
        evbus = SingletonEventBus.getBus();
        
//        //see if STUB_MODE is set as properties
//        String stubmode;
//        stubmode = System.getProperty("STUB_ENABLE");
//        
//        if ((stubmode ==null) || (!stubmode.equals("yes"))) {
//            //Execute MTP using IFA005 as SBI
//            System.out.println("///////STUB MODE DISABLE /////////");
//            stub_en = false;
//        } else {
//            System.out.println("///////STUB MODE ENABLE /////////");
//        }
        
        //register all modules
        System.out.println("XEN PLUGIN registering modules ...");

        evbus.register(mtpif);
        evbus.register(new XenIF());

        //register jaxrs api
        evbus.register(new ComputeResourcesApi());
        evbus.register(new HealthzApi());
        evbus.register(new InformationApi());
        evbus.register(new NetworkResourcesApi());
        evbus.register(new QuotasApi());
        evbus.register(new ReservationsApi());
        evbus.register(new SoftwareImagesApi());
                
        //class to register dead event
        evbus.register (new DeadEventListener());
        //register deadevent for debug
        System.out.println("Done !!!");
        System.out.println("Start acquiring abstract domain info... !!!");
        String domfile = args[0];
        Parsedomainlist domlist = new Parsedomainlist(domfile);
        evbus.post(domlist);
        //System.out.println("MTP ready ");
        System.out.println("Start MTP feature TEST:");
        while (!onexit) {
            
            prompt = scanner.next();
            if (prompt.equals("EXIT")) {
                StopServer servreq = new StopServer();
                evbus.post(servreq);
                onexit = true;
//                continue;
            } 
//            if (prompt.equals("ADVCOMPTEST")) {
//                soif.test_AdvertiseVirtualCompute();
//                continue;
//            }
//            if (prompt.equals("ADVNETTEST")) {
//                soif.test_AdvertiseVirtualNetork();
//                continue;
//            }
//            if (prompt.equals("ALLCOMPTEST")) {
//                soif.test_AllocateVirtualCompute();
//                continue;
//            }
//            if (prompt.equals("ALLNETTEST")) {
//                soif.test_AllocateVirtualNetwork();
//                continue;
//            }
//            if (prompt.equals("TERMCOMPTEST")) {
//                soif.test_TerminateVirtualCompute();
//                continue;
//            }
//            if (prompt.equals("TERMNETTEST")) {
//                soif.test_TerminateVirtualNetwork();
//            }
        }
        
    }
}