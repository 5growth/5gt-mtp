/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.common;

import java.util.*;
import com.google.common.eventbus.Subscribe;
import com.mtp.events.abstraction.Creation.Parsedomainlist;
import com.mtp.events.abstraction.Creation.DomainSubscriber;
import com.mtp.common.objects.DomainElem;
import com.mtp.SingletonEventBus;
import com.mtp.events.abstraction.Advertisement.AdvertiseE2EAbstractionReply;
import com.mtp.events.abstraction.Advertisement.AdvertiseE2EAbstractionRequest;
import com.mtp.events.abstraction.Advertisement.ComputeCapacityReply;
import com.mtp.events.abstraction.Advertisement.ComputeCapacityRequest;
import com.mtp.events.abstraction.Advertisement.ComputeResourceInformationReply;
import com.mtp.events.abstraction.Advertisement.ComputeResourceInformationRequest;
import com.mtp.events.abstraction.Advertisement.ComputeResourceZoneReply;
import com.mtp.events.abstraction.Advertisement.ComputeResourceZoneRequest;
import com.mtp.events.abstraction.Advertisement.NetworkCapacityReply;
import com.mtp.events.abstraction.Advertisement.NetworkCapacityRequest;
import com.mtp.events.abstraction.Advertisement.NetworkResourceInformationReply;
import com.mtp.events.abstraction.Advertisement.NetworkResourceInformationRequest;
import com.mtp.events.abstraction.Advertisement.NfviPopAbstractionReply;
import com.mtp.events.abstraction.Advertisement.NfviPopAbstractionRequest;
import com.mtp.events.abstraction.Creation.ComputeE2EAbstractionReply;
import com.mtp.events.abstraction.Creation.ComputeE2EAbstractionRequest;
import com.mtp.events.abstraction.Creation.MECResAbstractionEvent;
import com.mtp.events.abstraction.Creation.RadioResAbstractionEvent;
import com.mtp.events.abstraction.Creation.StartServer;
import com.mtp.events.abstraction.Creation.VIMResAbstractionEvent;
import com.mtp.events.abstraction.Creation.WIMResAbstractionEvent;
import com.mtp.events.resourcemanagement.ComputeAllocation.ComputeAllocateDBQuery;
import com.mtp.events.resourcemanagement.ComputeAllocation.ComputeAllocateDBQueryOutcome;
import com.mtp.events.resourcemanagement.ComputeAllocation.ComputeAllocateDBQueryReply;
import com.mtp.events.resourcemanagement.ComputeTermination.ComputeTerminateDBQuery;
import com.mtp.events.resourcemanagement.ComputeTermination.ComputeTerminateDBQueryOutcome;
import com.mtp.events.resourcemanagement.ComputeTermination.ComputeTerminateDBQueryReply;
import com.mtp.events.resourcemanagement.NetworkAllocation.NetworkAllocateDBQuery;
import com.mtp.events.resourcemanagement.NetworkAllocation.NetworkAllocateDBQueryOutcome;
import com.mtp.events.resourcemanagement.NetworkAllocation.NetworkAllocateDBQueryReply;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateDBQuery;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateDBQueryOutcome;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateDBQueryReply;
import com.mtp.extinterface.nbi.swagger.model.CapacityInformation;
import com.mtp.extinterface.nbi.swagger.model.NfviPop;
import com.mtp.extinterface.nbi.swagger.model.ResourceZone;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeResourceInformation;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeResourceInformationVirtualCPU;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeResourceInformationVirtualMemory;
import com.mtp.extinterface.nbi.swagger.model.VirtualNetworkResourceInformation;
import java.math.BigDecimal;
import com.mtp.DbConnectionPool.DbAbstractionDatasource;
import com.mtp.DbConnectionPool.DbDomainDatasource;
import com.mtp.DbConnectionPool.DbServiceDatasource;
import com.mtp.events.abstraction.Creation.DomainNumbers;
import com.mtp.events.resourcemanagement.ComputeAllocation.E2EComputeAllocateInstanceOutcome;
import com.mtp.events.resourcemanagement.ComputeTermination.E2EComputeTerminateInstanceOutcome;
import com.mtp.events.resourcemanagement.NetworkAllocation.E2ENetworkAllocateInstanceOutcome;
import com.mtp.events.resourcemanagement.NetworkTermination.E2ENetworkTerminateInstanceOutcome;
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequest;
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequestAffinityOrAntiAffinityConstraints;
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequestInterfaceData;
import com.mtp.extinterface.nbi.swagger.model.AllocateComputeRequestUserData;
import com.mtp.extinterface.nbi.swagger.model.AllocateNetworkResultNetworkDataNetworkQoS;

import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning;
import com.mtp.extinterface.nbi.swagger.model.InlineResponse200;
import com.mtp.extinterface.nbi.swagger.model.InlineResponse2001;
import com.mtp.extinterface.nbi.swagger.model.InterNfviPopConnectivityRequest;
import com.mtp.extinterface.nbi.swagger.model.LogicalLinkInterNfviPops;
import com.mtp.extinterface.nbi.swagger.model.LogicalLinkInterNfviPopsInner;
import com.mtp.extinterface.nbi.swagger.model.LogicalLinkInterNfviPopsInnerLogicalLinks;
import com.mtp.extinterface.nbi.swagger.model.LogicalLinkInterNfviPopsInnerLogicalLinksNetworkQoS;
import com.mtp.extinterface.nbi.swagger.model.MetaDataInner;

import com.mtp.extinterface.nbi.swagger.model.NfviPops;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInner;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributes;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesCpuResourceAttributes;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesMemoryResourceAttributes;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesResourceZoneAttributes;
import com.mtp.extinterface.nbi.swagger.model.NfviPopsInnerNfviPopAttributesStorageResourceAttributes;
import com.mtp.extinterface.nbi.swagger.model.ReservedVirtualComputeVirtualisationContainerReservedVirtualNetworkInterface;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeVirtualCpu;
import com.mtp.extinterface.nbi.swagger.model.VirtualComputeVirtualMemory;
import com.mtp.extinterface.nbi.swagger.model.VirtualNetwork;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class DatabaseDriver {

    private ArrayList<DomainElem> domains;
    private int domnum; //number of registered domain
    //private int currdomnum; //number of domain that reply  
    private long reqval;

    public DatabaseDriver() {
        domnum = 0;
        //currdomnum = 0;
        reqval = 0;
        domains = new ArrayList();
    }

    //////////////////Start Event Handlers///////////////////////////////
    @Subscribe
    public void handle_ParseDomainList(Parsedomainlist domlist) {
        System.out.println("DatabaseDriver ---> Parse domlist from xml file");
        //Parse list of domain from xml file
        XMLDomainParser xmldom = new XMLDomainParser(domlist.getFilename());
        long portdom = 0;
        DomainElem el;
        DomainSubscriber domsub = new DomainSubscriber();
        while (portdom != -1) {
            el = xmldom.getDomainElem();
            System.out.println("DomainElem fields: type= " + el.getType()
                    + " ip= " + el.getIp() + " port= " + el.getPort() + " name= "
                    + el.getName() + " id= " + el.getId());

// Insert domainElem into Database
            if (el.getPort() != -1) {
                try {

                    java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                    //PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop where AbstrNfviPopId=?");
                    //ps.setInt(1, 1);
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO domain (domId,name,type,ip,port) VALUES(?,?,?,?,?)");
                    ps.setLong(1, el.getId());
                    ps.setString(2, el.getName());
                    ps.setString(3, el.getType());
                    ps.setString(4, el.getIp());
                    ps.setLong(5, el.getPort());

                    ps.executeUpdate();
                    System.out.println("IP " + el.getIp() + "");

                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, null, ex);
                    System.out.println("DatabaseDriver ---> db exception: " + ex.getMessage());
                }

            }

            if (el.getPort() != -1) {
                domsub.setDomainElem(el);
                domains.add(el);
                domnum++;
            }

            portdom = el.getPort();
        }
        //post Domain Numbers to E2EAbstraction Logic
        DomainNumbers domnumev = new DomainNumbers(domnum);
        System.out.println("DatabaseDriver ---> Post DomainNumber event ");
        SingletonEventBus.getBus().post(domnumev);
        //post DomainSubscriberEvent to RO
        System.out.println("DatabaseDriver ---> Post DomainSubscriber event ");
        //currdomnum = 0;
        SingletonEventBus.getBus().post(domsub);
    }

    @Subscribe
    public void handle_WIMResAbstractionEvent(WIMResAbstractionEvent wimev) {
        System.out.println("DatabaseDriver ---> Handle WIMResAbstractionEvent");
        //Store information in DB

        //INSERT records into NfviPoP table
        //START - Loop on nfviPoP list
        for (int i = 0; i < wimev.getPopList().size(); i++) {

            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("INSERT INTO nfvipop ("
                        + "nfviPopId, "
                        + "vimId, "
                        + "geographicalLocationInfo,"
                        + "networkConnectivityEndpoint,"
                        + "domId) "
                        + "VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, wimev.getPopList().get(i).getNfviPopId());
                ps.setString(2, wimev.getPopList().get(i).getVimId());
                ps.setString(3, wimev.getPopList().get(i).getGeographicalLocationInfo());
                ps.setString(4, wimev.getPopList().get(i).getNetworkConnectivityEndpoint());
                ps.setLong(5, wimev.getId());

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_WIMResAbstractionEvent ---> NetworkService instance inserted into DB");
//            ResultSet rs = ps.getGeneratedKeys();
//
//            if (rs != null && rs.next()) {
//                networkServId = rs.getLong(1);
//                System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> netServId:" + networkServId + "");
//            }
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        } //END - INSERT on NfviPop table

        //INSERT records into Zone table
        for (int i = 0; i < wimev.getZoneList().size(); i++) {

            try {
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO zoneid"
                        + "(resourceZoneId,"
                        + "zoneId,"
                        + "zoneName,"
                        + "zoneState,"
                        + "zoneProperty,"
                        + "metadata)"
                        + "VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

//             PreparedStatement ps = conn.prepareStatement("INSERT INTO zoneid"
//                     + "(resourceZoneId,"
//                     + "zoneId,"
//                     + "zoneName,"
//                     + "zoneState,"
//                     + "zoneProperty)"
//                     + "VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, wimev.getZoneList().get(i).getZoneId());
                ps.setString(2, wimev.getZoneList().get(i).getZoneId());
                ps.setString(3, wimev.getZoneList().get(i).getZoneName());
                ps.setString(4, wimev.getZoneList().get(i).getZoneState());
                ps.setString(5, wimev.getZoneList().get(i).getZoneProperty());
                ps.setString(6, null);
                //Metadata attribute is a List of struct so we need a metadata table to handle this info  
                //ps.setString(6, wimev.getZoneList().get(i).getMetadata());

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_WIMResAbstractionEvent ---> NetworkService instance inserted into DB");

                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }

        //INSERT records into NetworkResources table
        for (int i = 0; i < wimev.getNetworkMapList().size(); i++) {

            //UPDATE ZONE table 
            try {
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT resourceZoneId, nfviPopId FROM  zoneid WHERE resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ps.setLong(1, wimev.getNetworkMapList().get(i).getZoneId());

                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    //availableBandwidth = rs.getLong("availableCapacity");     
                    rs.updateLong("nfviPopId", wimev.getNetworkMapList().get(i).getPopId());
                    rs.updateRow();
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("INSERT INTO networkresources\n"
                        + "(networkResId,"
                        + "srcGwId,\n"
                        + "dstGwId,\n"
                        + "srcGWIp,\n"
                        + "dstGwIp,\n"
                        + "delay,\n"
                        + "availableCapacity,\n"
                        + "reservedCapacity,\n"
                        + "totalCapacity,\n"
                        + "allocatedCapacity,\n"
                        + "networkResourceTypeId,\n"
                        + "networkType,\n"
                        + "bandwidth,\n"
                        + "resourceZoneId)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                //FABIO FIX WIM abstraction with new API
                ps.setString(1, wimev.getNetworkResList().get(i).getNetworkElem().getNetworkResourceTypeId());
                ps.setString(2, wimev.getNetworkResList().get(i).getLinkinfo().getSrcGwIpAddress());
                ps.setString(3, wimev.getNetworkResList().get(i).getLinkinfo().getDstGwIpAddress());
                ps.setString(4, Integer.toString(wimev.getNetworkResList().get(i).getLinkinfo().getLocalLinkId()));
                ps.setString(5, Integer.toString(wimev.getNetworkResList().get(i).getLinkinfo().getRemoteLinkId()));
                ps.setString(6, wimev.getNetworkResList().get(i).getNetworkElem().getNetworkQoS().get(0).getQosValue());
                ps.setString(7, wimev.getNetworkResList().get(i).getCapacityElem().getAvailableCapacity());
                ps.setString(8, wimev.getNetworkResList().get(i).getCapacityElem().getReservedCapacity());
                ps.setString(9, wimev.getNetworkResList().get(i).getCapacityElem().getTotalCapacity());
                ps.setString(10, wimev.getNetworkResList().get(i).getCapacityElem().getAllocatedCapacity());
                ps.setString(11, wimev.getNetworkResList().get(i).getNetworkElem().getNetworkResourceTypeId());
                ps.setString(12, wimev.getNetworkResList().get(i).getNetworkElem().getNetworkType());
                ps.setBigDecimal(13, wimev.getNetworkResList().get(i).getNetworkElem().getBandwidth());
                ps.setLong(14, wimev.getNetworkMapList().get(i).getZoneId());

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_WIMResAbstractionEvent ---> NetworkService instance inserted into DB");

                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);

                System.out.println("" + ex.getMessage() + "");
            }

        }
        ComputeE2EAbstractionRequest e2ecomputeev = new ComputeE2EAbstractionRequest();
        System.out.println("DatabaseDriver ---> Post ComputeE2EAbstractionRequest Event");
        SingletonEventBus.getBus().post(e2ecomputeev);

    }

    @Subscribe
    public void handle_VIMResAbstractionEvent(VIMResAbstractionEvent vimev) {
        System.out.println("DatabaseDriver ---> Handle VIMResAbstractionEvent");

        //Store information in DB
        //INSERT records into NfviPoP table
        //START - Loop on nfviPoP list
        for (int i = 0; i < vimev.getPopList().size(); i++) {

            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("INSERT INTO nfvipop ("
                        + "nfviPopId, "
                        + "vimId, "
                        + "geographicalLocationInfo,"
                        + "networkConnectivityEndpoint,"
                        + "domId) "
                        + "VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, vimev.getPopList().get(i).getNfviPopId());
                ps.setString(2, vimev.getPopList().get(i).getVimId());
                ps.setString(3, vimev.getPopList().get(i).getGeographicalLocationInfo());
                ps.setString(4, vimev.getPopList().get(i).getNetworkConnectivityEndpoint());
                ps.setLong(5, vimev.getId());

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_VIMResAbstractionEvent ---> NfviPoP instance inserted into DB");

                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        } //END - INSERT on NfviPop table

        //INSERT records into Zone table
        for (int i = 0; i < vimev.getZoneList().size(); i++) {

            try {
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO zoneid"
                        + "(resourceZoneId,"
                        + "zoneId,"
                        + "zoneName,"
                        + "zoneState,"
                        + "zoneProperty,"
                        + "metadata)"
                        + "VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, vimev.getZoneList().get(i).getZoneId());
                ps.setString(2, vimev.getZoneList().get(i).getZoneId());
                ps.setString(3, vimev.getZoneList().get(i).getZoneName());
                ps.setString(4, vimev.getZoneList().get(i).getZoneState());
                ps.setString(5, vimev.getZoneList().get(i).getZoneProperty());
                ps.setString(6, null);
                //Metadata attribute is a List of struct so we need a metadata table to handle this info  
                //ps.setString(6, wimev.getZoneList().get(i).getMetadata());

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_handle_VIMResAbstractionEvent ---> Zone instance inserted into DB");

                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
//UNCOMMENT if MTP has to manage network reosurces of VIM 
//        //INSERT records into NetworkResources table
//        for (int i = 0; i < vimev.getNetworkResList().size(); i++) {
//
//            try {
//
//                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
//
//                PreparedStatement ps = conn.prepareStatement("INSERT INTO networkresources"
//                        + "(networkResId,"
//                        + "srcGwId,"
//                        + "dstGwId,"
//                        + "srcGWIp,"
//                        + "dstGwIp,"
//                        + "delay,"
//                        + "availableCapacity,"
//                        + "reservedCapacity,"
//                        + "totalCapacity,"
//                        + "allocatedCapacity,"
//                        + "networkResourceTypeId,"
//                        + "networkType,"
//                        + "bandwidth)"
//                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//                
//                String ss= vimev.getNetworkResList().get(i).getNetworkElem().getResInfo().getSrcGwId();
//                 System.out.println("TEST ss:"+ss+"");
//                
//                ps.setString(1, vimev.getNetworkResList().get(i).getNetworkElem().getNetworkResourceTypeId());
//                ps.setString(2, vimev.getNetworkResList().get(i).getNetworkElem().getResInfo().getSrcGwId());
//                
//
//                //ps.setString(2, "1.1.1.1");
//                ps.setString(3, vimev.getNetworkResList().get(i).getNetworkElem().getResInfo().getDstGwId());
//                //ps.setString(3, "1.1.1.1");
//                ps.setString(4, vimev.getNetworkResList().get(i).getNetworkElem().getResInfo().getSrcGWIp());
//                //ps.setString(4, "1.1.1.1");
//               ps.setString(5, vimev.getNetworkResList().get(i).getNetworkElem().getResInfo().getDstGwIp());
//               //ps.setString(5, "1.1.1.1");
//                ps.setString(6, vimev.getNetworkResList().get(i).getNetworkElem().getNetworkQoS().getQosValue());
//                ps.setString(7, vimev.getNetworkResList().get(i).getCapacityElem().getAvailableCapacity());
//                ps.setString(8, vimev.getNetworkResList().get(i).getCapacityElem().getReservedCapacity());
//                ps.setString(9, vimev.getNetworkResList().get(i).getCapacityElem().getTotalCapacity());
//                ps.setString(10, vimev.getNetworkResList().get(i).getCapacityElem().getAllocatedCapacity());
//                ps.setString(11, vimev.getNetworkResList().get(i).getNetworkElem().getNetworkResourceTypeId());
//                ps.setString(12, vimev.getNetworkResList().get(i).getNetworkElem().getNetworkType());
//                ps.setBigDecimal(13, vimev.getNetworkResList().get(i).getNetworkElem().getBandwidth());
//
//                ps.executeUpdate();
//                System.out.println("DatabaseDriver.handle_VIMResAbstractionEvent ---> NetworkService instance inserted into DB");
//
//                ps.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DatabaseDriver.class
//                        .getName()).log(Level.SEVERE, null, ex);
//                  System.out.println("TEST TEST" + ex.getMessage()+ "");
//            }
//
//        }
//
//        //UPDATE ZONE and NETWORK_RESOURCES tables
//        for (int i = 0; i < vimev.getNetworkMapList().size(); i++) {
//            Long popId = vimev.getNetworkMapList().get(i).getPopId();
//            Long zoneId = vimev.getNetworkMapList().get(i).getZoneId();
//            Long resourceId = vimev.getNetworkMapList().get(i).getResourceId();
//
//            //UPDATE ZONE table 
//            try {
//                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
//                PreparedStatement ps = conn.prepareStatement("SELECT resourceZoneId, nfviPopId FROM  zoneid WHERE resourceZoneId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                ps.setLong(1, zoneId);
//
//                java.sql.ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                    //availableBandwidth = rs.getLong("availableCapacity");     
//                    rs.updateLong("nfviPopId", popId);
//                    rs.updateRow();
//                }
//
//                rs.close();
//                ps.close();
//
//            } catch (SQLException ex) {
//                Logger.getLogger(DatabaseDriver.class
//                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//
//            //UPDATE NETWORK_RESOURCES table 
//            try {
//                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
//                PreparedStatement ps = conn.prepareStatement("SELECT networkResId, resourceZoneId FROM networkresources WHERE networkResId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                ps.setLong(1, resourceId);
//
//                java.sql.ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                    //availableBandwidth = rs.getLong("availableCapacity");     
//                    rs.updateLong("resourceZoneId", zoneId);
//                    rs.updateRow();
//                }
//
//                rs.close();
//                ps.close();
//
//            } catch (SQLException ex) {
//                Logger.getLogger(DatabaseDriver.class
//                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//
//        }

        //INSERT records into MemoryResources and CpuResources tables
        for (int i = 0; i < vimev.getComputeResList().size(); i++) {

            //UPDATE ZONE table 
            try {
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT resourceZoneId, nfviPopId FROM  zoneid WHERE resourceZoneId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ps.setLong(1, vimev.getCompMapList().get(i).getZoneId());

                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    //availableBandwidth = rs.getLong("availableCapacity");     
                    rs.updateLong("nfviPopId", vimev.getCompMapList().get(i).getPopId());
                    rs.updateRow();
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            if (vimev.getComputeResList().get(i).getComputeElem().getVirtualMemory() != null) {

                //INSERT record in into MemoryResources table
                try {

                    java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO memoryresources"
                            + "(availableCapacity,"
                            + "reservedCapacity,"
                            + "totalCapacity,"
                            + "allocatedCapacity,"
                            + "virtualMemSize,"
                            + "virtualMemOversubscriptionPolicy,"
                            + "numaEnabled,"
                            + "computeResourceTypeId,"
                            + "accelerationCapability,"
                            + "resourceZoneId)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                    ps.setString(1, vimev.getComputeResList().get(i).getCapacityElem().getAvailableCapacity());
                    ps.setString(2, vimev.getComputeResList().get(i).getCapacityElem().getReservedCapacity());
                    ps.setString(3, vimev.getComputeResList().get(i).getCapacityElem().getTotalCapacity());
                    ps.setString(4, vimev.getComputeResList().get(i).getCapacityElem().getAllocatedCapacity());
                    ps.setBigDecimal(5, vimev.getComputeResList().get(i).getComputeElem().getVirtualMemory().getVirtualMemSize());
                    ps.setString(6, vimev.getComputeResList().get(i).getComputeElem().getVirtualMemory().getVirtualMemOversubscriptionPolicy());
                    ps.setBoolean(7, vimev.getComputeResList().get(i).getComputeElem().getVirtualMemory().isNumaSupported());
                    ps.setString(8, vimev.getComputeResList().get(i).getComputeElem().getComputeResourceTypeId());
                    ps.setString(9, vimev.getComputeResList().get(i).getComputeElem().getAccelerationCapability());
                    ps.setLong(10, vimev.getCompMapList().get(i).getZoneId());

                    ps.executeUpdate();
                    System.out.println("DatabaseDriver.handle_VIMResAbstractionEvent ---> NetworkService instance inserted into DB");

                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, null, ex);
                    System.out.println("" + ex.getMessage() + "");
                }

            } else {
                //INSERT record in into CpuResources table
                try {

                    java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("INSERT INTO cpuresources"
                            + "(availableCapacity,"
                            + "reservedCapacity,"
                            + "totalCapacity,"
                            + "allocatedCapacity,"
                            + "cpuArchitecture,"
                            + "numVirtualCpu,"
                            + "cpuClock,"
                            + "virtualCpuOversubscriptionPolicy,"
                            + "virtualCpuPinningSupported,"
                            + "computeResourceTypeId,"
                            + "accelerationCapability,"
                            + "resourceZoneId)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                    ps.setString(1, vimev.getComputeResList().get(i).getCapacityElem().getAvailableCapacity());
                    ps.setString(2, vimev.getComputeResList().get(i).getCapacityElem().getReservedCapacity());
                    ps.setString(3, vimev.getComputeResList().get(i).getCapacityElem().getTotalCapacity());
                    ps.setString(4, vimev.getComputeResList().get(i).getCapacityElem().getAllocatedCapacity());
                    ps.setString(5, vimev.getComputeResList().get(i).getComputeElem().getVirtualCPU().getCpuArchitecture());
                    ps.setBigDecimal(6, vimev.getComputeResList().get(i).getComputeElem().getVirtualCPU().getNumVirtualCpu());
                    ps.setBigDecimal(7, vimev.getComputeResList().get(i).getComputeElem().getVirtualCPU().getCpuClock());
                    ps.setString(8, vimev.getComputeResList().get(i).getComputeElem().getVirtualCPU().getVirtualCpuOversubscriptionPolicy());
                    //ps.setBoolean(9, vimev.getComputeResList().get(i).getComputeElem().getVirtualCPU().isVirtualCpuPinningSupported());
                    ps.setBoolean(9, true);
                    ps.setString(10, vimev.getComputeResList().get(i).getComputeElem().getComputeResourceTypeId());
                    ps.setString(11, vimev.getComputeResList().get(i).getComputeElem().getAccelerationCapability());
                    ps.setLong(12, vimev.getCompMapList().get(i).getZoneId());

                    ps.executeUpdate();
                    System.out.println("DatabaseDriver.handle_VIMResAbstractionEvent ---> NetworkService instance inserted into DB");

                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

        ComputeE2EAbstractionRequest e2ecomputeev = new ComputeE2EAbstractionRequest();
        System.out.println("DatabaseDriver ---> Post ComputeE2EAbstractionRequest Event");
        SingletonEventBus.getBus().post(e2ecomputeev);
    }

    @Subscribe
    public void handle_MECResAbstractionEvent(MECResAbstractionEvent mecev) {
        System.out.println("DatabaseDriver ---> Handle MECResAbstractionEvent");

        ComputeE2EAbstractionRequest e2ecomputeev = new ComputeE2EAbstractionRequest();
        System.out.println("DatabaseDriver ---> Post ComputeE2EAbstractionRequest Event");
        SingletonEventBus.getBus().post(e2ecomputeev);
    }

    @Subscribe
    public void handle_RadioResAbstractionEvent(RadioResAbstractionEvent radioev) {
        System.out.println("DatabaseDriver ---> Handle RadioResAbstractionEvent");
        ComputeE2EAbstractionRequest e2ecomputeev = new ComputeE2EAbstractionRequest();
        System.out.println("DatabaseDriver ---> Post ComputeE2EAbstractionRequest Event");
        SingletonEventBus.getBus().post(e2ecomputeev);
    }

    @Subscribe
    public void handle_ComputeE2EAbstractionReply(ComputeE2EAbstractionReply e2ecomprep) {
        System.out.println("DatabaseDriver ---> Handle ComputeE2EAbstractionReply Event");
        //TODO: Perform E2E aggregation view and fill DB using JDBC driver
        System.out.println("DatabaseDriver ---> DB filled...");
        StartServer servreq = new StartServer();
        SingletonEventBus.getBus().post(servreq);
        System.out.println("DatabaseDriver ---> Start Server http");
    }

    //////////////////Advertisement Event Handlers///////////////////////////////
   @Subscribe
    public void handle_AdvertiseE2EAbstractionRequest(AdvertiseE2EAbstractionRequest e2eadvreq) {
       System.out.println("DatabaseDriver ---> Handle AdvertiseE2EAbstractionRequest Event");
       System.out.println("field event: (reqid) = ("
               + e2eadvreq.getReqId() + ")");

       InlineResponse2001 resp = new InlineResponse2001();
       List<NfviPop> poplist = new ArrayList();
       List<NfviPopsInnerNfviPopAttributes> popattrlist = new ArrayList();

       //Retrieve NFVIPOP
       try {
           java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

           //PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop where AbstrNfviPopId=?");
           //ps.setInt(1, 1);
           PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop");

           java.sql.ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               NfviPop nfviPop = new NfviPop();
               nfviPop.setNfviPopId(rs.getString("abstrNfviPopId"));
               nfviPop.setGeographicalLocationInfo(rs.getString("geographicalLocationInfo"));
               nfviPop.setVimId(rs.getString("vimId"));
               nfviPop.setNetworkConnectivityEndpoint(rs.getString("networkConnectivityEndpoint"));

               System.out.println("nfviPop.abstrNfviPopId: " + nfviPop.getNfviPopId() + "");
               System.out.println("nfviPop.GeographicalLocationInfo: " + nfviPop.getGeographicalLocationInfo() + "");
               System.out.println("nfviPop.VimId: " + nfviPop.getVimId() + "");
               System.out.println("nfviPop.NetworkConnectivityEndpoint: " + nfviPop.getNetworkConnectivityEndpoint() + "");

               poplist.add(nfviPop);
               //nfviPop.add(blog);
           }
           rs.close();
           ps.close();

       } catch (SQLException ex) {
           Logger.getLogger(DatabaseDriver.class
                   .getName()).log(Level.SEVERE, null, ex);
       }
       NfviPops popslist = new NfviPops();
       //retrieve zone and resources for each nfvipop
       for (int i = 0; i < poplist.size(); i++) {
           NfviPop popel = poplist.get(i);
           NfviPopsInnerNfviPopAttributes popattr = new NfviPopsInnerNfviPopAttributes();
           //fill nfvipop values
           popattr.setVimId(popel.getVimId());
           popattr.setNfviPopId(popel.getNfviPopId());
           popattr.setGeographicalLocationInfo(popel.getGeographicalLocationInfo());
           //fill connectivity endpoint
           List<NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint> endplist = new ArrayList();
           String popstr = popel.getNetworkConnectivityEndpoint();
           String[] poptoken = popstr.split(";");
           for (int tok = 0; tok < poptoken.length; tok++) {
               NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint endpel = new NfviPopsInnerNfviPopAttributesNetworkConnectivityEndpoint();
               endpel.setNetGwIpAddress(poptoken[tok]);
               endplist.add(endpel);
           }
           popattr.setNetworkConnectivityEndpoint(endplist);
           //retrieve resource zone for nfvipop
           List<NfviPopsInnerNfviPopAttributesResourceZoneAttributes> zonelist = new ArrayList();

           try {
               java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

               //PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop where AbstrNfviPopId=?");
               //ps.setInt(1, 1);
               PreparedStatement ps = conn.prepareStatement("Select * from abstrzoneid where abstrNfviPopId=?");
               
               ps.setString(1, poplist.get(i).getNfviPopId());
               java.sql.ResultSet rs = ps.executeQuery();
               while (rs.next()) {
                   NfviPopsInnerNfviPopAttributesResourceZoneAttributes zonel = new NfviPopsInnerNfviPopAttributesResourceZoneAttributes();
                   zonel.setZoneId(rs.getString("abstrResourceZoneId"));
                   zonel.setZoneName(rs.getString("zoneName"));
                   zonel.setZoneProperty(rs.getString("zoneProperty"));
                   zonel.setZoneState(rs.getString("zoneState"));
                   zonel.setMetadata(rs.getString("metadata"));

                   System.out.println("zoneid.zoneid: " + zonel.getZoneId() + "");
                   System.out.println("zoneid.zonename: " + zonel.getZoneName() + "");
                   System.out.println("zoneid.zoneproperty: " + zonel.getZoneProperty() + "");
                   System.out.println("zoneid.zonestate: " + zonel.getZoneState() + "");
                   System.out.println("zoneid.metadata: " + zonel.getMetadata() + "");

                   zonelist.add(zonel);
                   //nfviPop.add(blog);
               }
               rs.close();
               ps.close();

           } catch (SQLException ex) {
               Logger.getLogger(DatabaseDriver.class
                       .getName()).log(Level.SEVERE, null, ex);
           }

           for (int j = 0; j < zonelist.size(); j++) {
               //retrieve cpu resources
               try {
                   java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                   PreparedStatement ps = conn.prepareStatement("Select * from abstrcpuresources where abstrResourceZoneId=?");

                   ps.setString(1, zonelist.get(j).getZoneId());
                   java.sql.ResultSet rs = ps.executeQuery();
                   while (rs.next()) {
                       NfviPopsInnerNfviPopAttributesCpuResourceAttributes cpuel = new NfviPopsInnerNfviPopAttributesCpuResourceAttributes();
                       cpuel.setAllocatedCapacity(rs.getString("allocatedCapacity"));
                       cpuel.setAvailableCapacity(rs.getString("availableCapacity"));
                       cpuel.setReservedCapacity(rs.getString("reservedCapacity"));
                       cpuel.setTotalCapacity(rs.getString("totalCapacity"));


                       System.out.println("cpu.allocatedCapacity: " + cpuel.getAllocatedCapacity() + "");
                       System.out.println("cpu.availableCapacity: " + cpuel.getAvailableCapacity() + "");
                       System.out.println("cpu.reservedCapacity: " + cpuel.getReservedCapacity() + "");
                       System.out.println("cpu.totalCapacity: " + cpuel.getTotalCapacity() + "");

                       zonelist.get(j).setCpuResourceAttributes(cpuel);
                       //nfviPop.add(blog);
                   }
                   rs.close();
                   ps.close();

               } catch (SQLException ex) {
                   Logger.getLogger(DatabaseDriver.class
                           .getName()).log(Level.SEVERE, null, ex);
               }
               
               //retrieve memory resources
               try {
                   java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                   PreparedStatement ps = conn.prepareStatement("Select * from abstrmemoryresources where abstrResourceZoneId=?");

                   ps.setString(1, zonelist.get(j).getZoneId());
                   java.sql.ResultSet rs = ps.executeQuery();
                   while (rs.next()) {
                       NfviPopsInnerNfviPopAttributesMemoryResourceAttributes memel = new NfviPopsInnerNfviPopAttributesMemoryResourceAttributes();
                       memel.setAllocatedCapacity(rs.getString("allocatedCapacity"));
                       memel.setAvailableCapacity(rs.getString("availableCapacity"));
                       memel.setReservedCapacity(rs.getString("reservedCapacity"));
                       memel.setTotalCapacity(rs.getString("totalCapacity"));


                       System.out.println("mem.allocatedCapacity: " + memel.getAllocatedCapacity() + "");
                       System.out.println("mem.availableCapacity: " + memel.getAvailableCapacity() + "");
                       System.out.println("mem.reservedCapacity: " + memel.getReservedCapacity() + "");
                       System.out.println("mem.totalCapacity: " + memel.getTotalCapacity() + "");

                       zonelist.get(j).setMemoryResourceAttributes(memel);
                       //nfviPop.add(blog);
                   }
                   rs.close();
                   ps.close();

               } catch (SQLException ex) {
                   Logger.getLogger(DatabaseDriver.class
                           .getName()).log(Level.SEVERE, null, ex);
               }
               
               //retrieve storage resources
               try {
                   java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                   PreparedStatement ps = conn.prepareStatement("Select * from abstrstorageresources where abstrResourceZoneId=?");

                   ps.setString(1, zonelist.get(j).getZoneId());
                   java.sql.ResultSet rs = ps.executeQuery();
                   while (rs.next()) {
                       NfviPopsInnerNfviPopAttributesStorageResourceAttributes storel = new NfviPopsInnerNfviPopAttributesStorageResourceAttributes();
                       storel.setAllocatedCapacity(rs.getString("allocatedCapacity"));
                       storel.setAvailableCapacity(rs.getString("availableCapacity"));
                       storel.setReservedCapacity(rs.getString("reservedCapacity"));
                       storel.setTotalCapacity(rs.getString("totalCapacity"));


                       System.out.println("storage.allocatedCapacity: " + storel.getAllocatedCapacity() + "");
                       System.out.println("storage.availableCapacity: " + storel.getAvailableCapacity() + "");
                       System.out.println("storage.reservedCapacity: " + storel.getReservedCapacity() + "");
                       System.out.println("storage.totalCapacity: " + storel.getTotalCapacity() + "");

                       zonelist.get(j).setStorageResourceAttributes(storel);
                       //nfviPop.add(blog);
                   }
                   rs.close();
                   ps.close();

               } catch (SQLException ex) {
                   Logger.getLogger(DatabaseDriver.class
                           .getName()).log(Level.SEVERE, null, ex);
               }
           } //ZONE FOR END
           //insert in popattributes
           popattr.setResourceZoneAttributes(zonelist);
           NfviPopsInner popinel = new NfviPopsInner();
           popinel.setNfviPopAttributes(popattr);
           
           popslist.add(popinel);
 
       } //NFVIPOP FOR END
       //add nfvipops in respones
       resp.setNfviPops(popslist);
       
       //Insert logical link info
       LogicalLinkInterNfviPops linklist = new LogicalLinkInterNfviPops();
       
       //retrieve logical link info
       try {
           java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

           //PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop where AbstrNfviPopId=?");
           //ps.setInt(1, 1);
           PreparedStatement ps = conn.prepareStatement("Select * from logicallink");

           java.sql.ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               LogicalLinkInterNfviPopsInner linkpopel = new LogicalLinkInterNfviPopsInner();
               LogicalLinkInterNfviPopsInnerLogicalLinks linkinel = new LogicalLinkInterNfviPopsInnerLogicalLinks();
               LogicalLinkInterNfviPopsInnerLogicalLinksNetworkQoS linkinqos = new LogicalLinkInterNfviPopsInnerLogicalLinksNetworkQoS();
               
               //retrieve network qos
               linkinqos.setLinkCost("metric");
               linkinqos.setLinkCostValue(BigDecimal.ONE);
               linkinqos.setLinkDelay("delay");
               linkinqos.setLinkDelayValue( new BigDecimal(rs.getShort("delay")));
               linkinel.setNetworkQoS(linkinqos);
               
               //set inner element
               linkinel.setAvailableBandwidth(new BigDecimal(rs.getString("availableBandwidth")));
               linkinel.setDstGwIpAddress(rs.getString("dstRouterId"));
               linkinel.setInterNfviPopNetworkTopology("p2p");
               linkinel.setInterNfviPopNetworkType("L2VPN,L3VPN,VXLAN");
               linkinel.setLocalLinkId(Integer.parseInt(rs.getString("srcRouterIp")));
               linkinel.setLogicalLinkId(rs.getString("logicalLinkId"));
               linkinel.setRemoteLinkId(Integer.parseInt(rs.getString("dstRouterIp")));
               linkinel.setSrcGwIpAddress(rs.getString("srcRouterId"));
               linkinel.setTotalBandwidth(new BigDecimal(rs.getString("totalBandwidth")));
               linkinel.setNetworkLayer("IP/MPLS");
               
               System.out.println("link.delay: " + linkinqos.getLinkDelayValue() + "");
               System.out.println("link.availableBandwidth: " + linkinel.getAvailableBandwidth() + "");
               System.out.println("link.totalBandwidth: " + linkinel.getTotalBandwidth() + "");
               System.out.println("link.srcGwId: " + linkinel.getSrcGwIpAddress() + "");
               System.out.println("link.dstGwId: " + linkinel.getDstGwIpAddress() + "");
               System.out.println("link.localid: " + linkinel.getLocalLinkId() + "");
               System.out.println("link.remoteid: " + linkinel.getRemoteLinkId() + "");

               linkpopel.setLogicalLinks(linkinel);
               linklist.add(linkpopel);
               //nfviPop.add(blog);
           }
           rs.close();
           ps.close();

       } catch (SQLException ex) {
           Logger.getLogger(DatabaseDriver.class
                   .getName()).log(Level.SEVERE, null, ex);
       }
       
       //add linklist in response
       resp.setLogicalLinkInterNfviPops(linklist);
       
       AdvertiseE2EAbstractionReply e2eadvrep = new AdvertiseE2EAbstractionReply(e2eadvreq.getReqId(), resp);
       System.out.println("DatabaseDriver --->  Post AdvertiseE2EAbstractionReply Event");
       SingletonEventBus.getBus().post(e2eadvrep);
    }
    
    @Subscribe
    public void handle_NfviPopAbstractionRequest(NfviPopAbstractionRequest nfvipopreq) {
        System.out.println("DatabaseDriver ---> Handle NfviPopAbstractionRequest Event");
        System.out.println("field event: (reqid,filter) = ("
                + nfvipopreq.getReqId() + "," + nfvipopreq.getFilter() + ")");
        NfviPopAbstractionReply nfvipoprep = new NfviPopAbstractionReply(nfvipopreq.getReqId(), nfvipopreq.getComputeFlag(), nfvipopreq.getNetworkFlag());

        try {
            java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

            //PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop where AbstrNfviPopId=?");
            //ps.setInt(1, 1);
            PreparedStatement ps = conn.prepareStatement("Select * from abstrnfvipop");

            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NfviPop nfviPop = new NfviPop();
                nfviPop.setNfviPopId(rs.getString("abstrNfviPopId"));
                nfviPop.setGeographicalLocationInfo(rs.getString("geographicalLocationInfo"));
                nfviPop.setVimId(rs.getString("vimId"));
                nfviPop.setNetworkConnectivityEndpoint(rs.getString("networkConnectivityEndpoint"));

                System.out.println("nfviPop.abstrNfviPopId: " + nfviPop.getNfviPopId() + "");
                System.out.println("nfviPop.GeographicalLocationInfo: " + nfviPop.getGeographicalLocationInfo() + "");
                System.out.println("nfviPop.VimId: " + nfviPop.getVimId() + "");
                System.out.println("nfviPop.NetworkConnectivityEndpoint: " + nfviPop.getNetworkConnectivityEndpoint() + "");

                nfvipoprep.addnfvipop(nfviPop);
                //nfviPop.add(blog);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("DatabaseDriver --->  Post NfviPopAbstractionReply Event");
        SingletonEventBus.getBus().post(nfvipoprep);

        /*
        //Now add two fixed entries
        NfviPopAbstractionReply nfvipoprep = new NfviPopAbstractionReply(nfvipopreq.getReqId(), nfvipopreq.getComputeFlag(), nfvipopreq.getNetworkFlag());
        NfviPop nfvipopel = new NfviPop();
        nfvipopel.geographicalLocationInfo("Spain");
        nfvipopel.nfviPopId("1");
        nfvipopel.networkConnectivityEndpoint("10.11.12.13");
        nfvipopel.vimId("11");
        nfvipoprep.addnfvipop(nfvipopel);
        nfvipopel = new NfviPop();
        nfvipopel.geographicalLocationInfo("Italy");
        nfvipopel.nfviPopId("2");
        nfvipopel.networkConnectivityEndpoint("20.21.22.23");
        nfvipopel.vimId("21");
        nfvipoprep.addnfvipop(nfvipopel);
 
        System.out.println("DatabaseDriver --->  Post NfviPopAbstractionReply Event");
        SingletonEventBus.getBus().post(nfvipoprep);
         */
    }

    @Subscribe
    public void handle_NetworkCapacityRequest(NetworkCapacityRequest capreq) {
        System.out.println("DatabaseDriver ---> Handle NetworkCapacityRequest Event");
        System.out.println("field event: (reqid) = ("
                + capreq.getReqId() + ")");
        //TODO: retrieve E2E abstraction info via DB query using JDBC driver
        //Now add fixed entries
        NetworkCapacityReply caprep = new NetworkCapacityReply(capreq.getReqId());
        CapacityInformation cap = new CapacityInformation();
        cap.setAllocatedCapacity("100000000");
        cap.setAvailableCapacity("900000000");
        cap.setReservedCapacity("0");
        cap.setTotalCapacity("1000000000");
        caprep.setCapacityInfo(cap);
        System.out.println("DatabaseDriver --->  Post NetworkCapacityReply Event");
        SingletonEventBus.getBus().post(capreq);
    }

    @Subscribe
    public void handle_NetworkResourceInformationRequest(NetworkResourceInformationRequest resinforeq) {
        System.out.println("DatabaseDriver ---> Handle NetworkResourceInformationRequest Event");
        System.out.println("field event: (reqid,filter) = ("
                + resinforeq.getReqId() + "," + resinforeq.getFilter() + ")");
        //TODO: retrieve E2E abstraction info via DB query using JDBC driver
        //Now add two fixed entries
        NetworkResourceInformationReply resinforep = new NetworkResourceInformationReply(resinforeq.getReqId());
        VirtualNetworkResourceInformation netres = new VirtualNetworkResourceInformation();
        AllocateNetworkResultNetworkDataNetworkQoS qos = new AllocateNetworkResultNetworkDataNetworkQoS();
        qos.setQosName("delay");
        qos.setQosValue("10");
        netres.setNetworkType("vxlan");
        netres.setNetworkResourceTypeId("1");
        List<AllocateNetworkResultNetworkDataNetworkQoS> qoslist = new ArrayList();
        qoslist.add(qos);
        netres.setNetworkQoS(qoslist);
        netres.setBandwidth(BigDecimal.valueOf(Long.valueOf("1250000")));
        resinforep.addnetresinfo(netres);

        netres = new VirtualNetworkResourceInformation();
        qos = new AllocateNetworkResultNetworkDataNetworkQoS();
        qoslist = new ArrayList();
        qos.setQosName("delay");
        qos.setQosValue("5");
        qoslist.add(qos);
        netres.setNetworkType("gre");
        netres.setNetworkResourceTypeId("2");
        netres.setNetworkQoS(qoslist);
        netres.setBandwidth(BigDecimal.valueOf(Long.valueOf("750000")));
        resinforep.addnetresinfo(netres);

        System.out.println("DatabaseDriver --->  Post NetworkResourceInformationReply Event");
        SingletonEventBus.getBus().post(resinforep);
    }

    @Subscribe
    public void handle_ComputeResourceZoneRequest(ComputeResourceZoneRequest zonereq) {
        System.out.println("DatabaseDriver ---> Handle ComputeResourceZoneRequest Event");
        System.out.println("field event: (reqid,filter) = ("
                + zonereq.getReqId() + "," + zonereq.getFilter() + ")");
        //TODO: retrieve E2E abstraction info via DB query using JDBC driver
        //Now add two fixed entries
        ComputeResourceZoneReply zonerep = new ComputeResourceZoneReply(zonereq.getReqId());
        ResourceZone zonel = new ResourceZone();

        zonel.setNfviPopId("11");
        zonel.setZoneId("1");
        zonel.setZoneName("Madrid");
        //zonel.setZoneProperty(zoneProperty);
        zonel.setZoneState("enabled");
        zonerep.addnetresinfo(zonel);
        zonel = new ResourceZone();
        zonel.setNfviPopId("11");
        zonel.setZoneId("2");
        zonel.setZoneName("Leganes");
        //zonel.setZoneProperty(zoneProperty);
        zonel.setZoneState("enabled");
        zonerep.addnetresinfo(zonel);
        System.out.println("DatabaseDriver --->  Post ComputeResourceZoneReply Event");
        SingletonEventBus.getBus().post(zonerep);
    }

    @Subscribe
    public void handle_ComputeResourceInformationRequest(ComputeResourceInformationRequest capreq) {
        System.out.println("DatabaseDriver ---> Handle ComputeResourceInformationRequest Event");
        System.out.println("field event: (reqid,filter) = ("
                + capreq.getReqId() + "," + capreq.getFilter() + ")");
        //TODO: retrieve E2E abstraction info via DB query using JDBC driver
        //Now add two fixed entries
        ComputeResourceInformationReply caprep = new ComputeResourceInformationReply(capreq.getReqId());

        VirtualComputeResourceInformation infoel = new VirtualComputeResourceInformation();
        VirtualComputeResourceInformationVirtualCPU cpuel = new VirtualComputeResourceInformationVirtualCPU();
        VirtualComputeResourceInformationVirtualMemory memel = new VirtualComputeResourceInformationVirtualMemory();
        double clock = 123.456;
        double numcpu = 2000;
        double memsize = 100.04;
        cpuel.setCpuArchitecture("x86_64");
        cpuel.setCpuClock(BigDecimal.valueOf(clock));
        cpuel.setNumVirtualCpu(BigDecimal.valueOf(numcpu));
        cpuel.setVirtualCpuPinningSupported(false);
        memel.setNumaSupported(true);
        memel.setVirtualMemSize(BigDecimal.valueOf(memsize));
        infoel.setComputeResourceTypeId("21");
        infoel.setVirtualCPU(cpuel);
        infoel.setVirtualMemory(memel);
        caprep.addnetresinfo(infoel);
        infoel = new VirtualComputeResourceInformation();
        cpuel = new VirtualComputeResourceInformationVirtualCPU();
        memel = new VirtualComputeResourceInformationVirtualMemory();
        clock = 345.897;
        numcpu = 1000;
        memsize = 200.90;
        cpuel.setCpuArchitecture("arm");
        cpuel.setCpuClock(BigDecimal.valueOf(clock));
        cpuel.setNumVirtualCpu(BigDecimal.valueOf(numcpu));
        cpuel.setVirtualCpuPinningSupported(true);
        caprep.addnetresinfo(infoel);
        memel.setNumaSupported(false);
        memel.setVirtualMemSize(BigDecimal.valueOf(memsize));
        infoel.setComputeResourceTypeId("22");
        infoel.setVirtualCPU(cpuel);
        infoel.setVirtualMemory(memel);
        caprep.addnetresinfo(infoel);
        System.out.println("DatabaseDriver --->  Post ComputeResourceInformationReply Event");
        SingletonEventBus.getBus().post(caprep);
    }

    @Subscribe
    public void handle_ComputeCapacityRequest(ComputeCapacityRequest capreq) {
        System.out.println("DatabaseDriver ---> Handle ComputeCapacityRequest Event");
        System.out.println("field event: (reqid) = ("
                + capreq.getReqId() + ")");
        //TODO: retrieve E2E abstraction info via DB query using JDBC driver
        //Now add two fixed entries
        ComputeCapacityReply caprep = new ComputeCapacityReply(capreq.getReqId());
        CapacityInformation cap = new CapacityInformation();
        cap.setAllocatedCapacity("100");
        cap.setAvailableCapacity("300");
        cap.setReservedCapacity("200");
        cap.setTotalCapacity("600");
        caprep.setCapacityInfo(cap);
        System.out.println("DatabaseDriver --->  Post ComputeCapacityReply Event");
        SingletonEventBus.getBus().post(capreq);
    }

    //////////////////Allocate Event Handlers///////////////////////////////
    @Subscribe
    public void handle_ComputeAllocateDBQuery(ComputeAllocateDBQuery dbquery) {
        System.out.println("DatabaseDriver --->  Handle ComputeAllocateDBQuery Event");

        String abstrNfviPopId = null;
// START - Insert servID into Service table
        try {

            java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO service (servId) VALUES(?)");
            ps.setLong(1, dbquery.getServid());

            ps.executeUpdate();
            ps.close();

        } catch (SQLIntegrityConstraintViolationException ex) {
//            Logger.getLogger(ResourceSelectionLogic.class
//                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("DatabaseDriver.handle_ComputeAllocateDBQuery ---> SQLIntegrityConstraintViolationException: ServiceId is already in the DB");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
// END - Insert
        
        List<MetaDataInner> metadata = dbquery.getComputereq().getMetadata();
        for (int i=0; i < metadata.size(); i++) {
            if (metadata.get(i).getKey().compareTo("AbstractNfviPopId") == 0) {
                abstrNfviPopId= metadata.get(i).getValue();
            }
        } 

        //START - Retrieve from DB the list of nfviPopId and domId related to the abstrNfviPopId provided in the AllocateComputeRequest. 
        ArrayList<Long> vimlist = new ArrayList();
        ArrayList<Long> domlist = new ArrayList();
        System.out.println("DatabaseDriver.handle_ComputeAllocateDBQuery ---> AbstrNfviPopId: " + abstrNfviPopId + "");
        try {
            java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("Select nfviPopId, domId from nfvipop where abstrNfviPopId=?");
            ps.setString(1, abstrNfviPopId);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vimlist.add(rs.getLong("nfviPopId"));
                domlist.add(rs.getLong("domId"));
                // vimlist.add(elementCount,vimElem);
                //nfviPopIdList.add(elementCount,rs.getString("NfviPopId"));

                System.out.println("DatabaseDriver.handle_ComputeAllocateDBQuery ---> NfviPopId: " + rs.getString("NfviPopId") + "");

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        ComputeAllocateDBQueryReply dbreply = new ComputeAllocateDBQueryReply(dbquery.getReqid(), dbquery.getServid(), domlist, vimlist);
        System.out.println("DatabaseDriver --->  Post ComputeAllocateDBQueryReply Event");
        SingletonEventBus.getBus().post(dbreply);

    }

    @Subscribe
    public void handle_ComputeAllocateDBQueryOutcome(ComputeAllocateDBQueryOutcome dboutcome) {
        System.out.println("DatabaseDriver --->  Handle ComputeAllocateDBQueryOutcome Event");
        //TODO update DB using JDBC raising exception if something is wrong

        if (dboutcome.isOutcome() == false) {
            //send API reply with void virtualcompute Instance

            E2EComputeAllocateInstanceOutcome allneginst = new E2EComputeAllocateInstanceOutcome(dboutcome.getReqid(),
                    dboutcome.getServid(), null, dboutcome.isOutcome());
            System.out.println("DatabaseDriver --> Post E2EComputeAllocateInstanceOutcome  Negative outcome Event");
            SingletonEventBus.getBus().post(allneginst);
            return;
        }
// START - INSERT ENTRY in ComputeServices Table
        Long computeServId = null;
        Long numVirtualCpu = null;
        Long storageSize = null;
        Long memorySize = null;
        String zoneId = null;
        Long virtualcomputeId = null;

        if (dboutcome.isOutcome()) {

            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("INSERT INTO computeservices (reqId,status,servId,nfviPopId) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                ps.setLong(1, dboutcome.getReqid());
                ps.setString(2, "enabled");
                ps.setLong(3, dboutcome.getServid());
                ps.setLong(4, dboutcome.getNfvipopid());
                //ps.setString(5,null);

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> ComputeService instance inserted into DB");
                ResultSet rs = ps.getGeneratedKeys();

                if (rs != null && rs.next()) {
                    computeServId = rs.getLong(1);
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> computeServId:" + computeServId + "");
                }

                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

//END - Insert       
//        
            //START - INSERT AllocateComputeRequest into DB
            AllocateComputeRequest allocComputeReq = dboutcome.getComputerequest();

            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                // Insert  data into computeservicerequestdata table
                PreparedStatement ps = conn.prepareStatement("INSERT INTO computeservicerequestdata (locationConstraints, reservationId, computeFlavourId,resourceGroupId, metadata,vcImageId,computeName,computeServiceId) VALUES(?,?,?,?,?,?,?,?)");
                ps.setString(1, allocComputeReq.getLocationConstraints());
                ps.setString(2, allocComputeReq.getReservationId());
                ps.setString(3, allocComputeReq.getComputeFlavourId());
                ps.setString(4, allocComputeReq.getResourceGroupId());
                ps.setObject(5, ""); //FABIO: metadata is an array not more a string
                ps.setString(6, allocComputeReq.getVcImageId());
                ps.setString(7, allocComputeReq.getComputeName());
                ps.setLong(8, computeServId);

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> AllocateComputeRequest data inserted into DB");

                ps.close();

                // Insert  data into virtualinterfacedata table
                List<AllocateComputeRequestInterfaceData> interfacelist = allocComputeReq.getInterfaceData();
                if (interfacelist != null) {
                    long size = interfacelist.size();
                    for (int i = 0; i < size; i++) {

                        AllocateComputeRequestInterfaceData interfacedata = interfacelist.get(i);
                        PreparedStatement ps_interfacedata = conn.prepareStatement("INSERT INTO  virtualinterfacedata "
                                + "(ipAddress, "
                                + "macAddress, "
                                + "computeServiceId) "
                                + "VALUES(?,?,?)");
                        ps_interfacedata.setString(1, interfacedata.getIpAddress());
                        ps_interfacedata.setString(2, interfacedata.getMacAddress());
                        ps_interfacedata.setLong(3, computeServId);
                        ps_interfacedata.executeUpdate();
                        System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> VirtualInterfaceData record inserted into DB");
                        ps_interfacedata.close();
                    }
                }

                // Insert  data into affinityorantiaffinity table
                List<AllocateComputeRequestAffinityOrAntiAffinityConstraints> constraintList = allocComputeReq.getAffinityOrAntiAffinityConstraints();
                if (constraintList != null) {
                    long size = constraintList.size();
                    for (int i = 0; i < size; i++) {
                        AllocateComputeRequestAffinityOrAntiAffinityConstraints constraint = constraintList.remove(0);
                        PreparedStatement ps_affinityConstraint = conn.prepareStatement("INSERT INTO affinityorantiaffinityconstraint"
                                + "(type,"
                                + "scope,"
                                + "affinityAntiAffinityResourceList,"
                                + "affinityAntiAffinityResourceGroup,"
                                + "computeServiceId) "
                                + "VALUES(?,?,?,?,?)");
                        ps_affinityConstraint.setString(1, constraint.getType());
                        ps_affinityConstraint.setString(2, constraint.getType());
                        ps_affinityConstraint.setString(3,  constraint.getAffinityAntiAffinityResourceList().getResource().get(0));
                        ps_affinityConstraint.setString(4, constraint.getAffinityAntiAffinityResourceGroup());
                        ps_affinityConstraint.setLong(5, computeServId);
                        ps_affinityConstraint.executeUpdate();
                        System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> AffinityConstraints record inserted into DB");
                        ps_affinityConstraint.close();
                    }
                }

                // Insert  data into userdata table
                AllocateComputeRequestUserData userData = allocComputeReq.getUserData();
                if (userData != null) {
                    PreparedStatement ps_userdata = conn.prepareStatement("INSERT INTO userdata "
                            + "(content,"
                            + "method,"
                            + "computeServiceId) "
                            + "VALUES(?,?,?)");
                    ps_userdata.setString(1, userData.getContent());
                    ps_userdata.setString(2, userData.getMethod());
                    ps_userdata.setLong(3, computeServId);

                    ps_userdata.executeUpdate();
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Userdata record inserted into DB");
                    ps_userdata.close();

                }

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
//END - Insert

// START - Insert record in virtualcompute table
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                //Note that virtualComputeId is auto_generated. It must replace the computeId provided by the domain in the REST response. 
                PreparedStatement ps = conn.prepareStatement("INSERT INTO virtualcompute "
                        + "(computeId,"
                        + "zoneId,"
                        + "virtualDisks,"
                        + "vcImageId,"
                        + "flavourId,"
                        + "computeServiceId,"
                        + "computeName,"
                        + "operationalState,"
                        + "hostId) "
                        + "VALUES(?,?,?,?,?,?,?,?,?)");

                ps.setString(1, dboutcome.getComputereply().getComputeId());
                ps.setString(2, dboutcome.getComputereply().getZoneId());
                ps.setString(3, dboutcome.getComputereply().getVirtualDisks());
                ps.setString(4, dboutcome.getComputereply().getVcImageId());
                ps.setString(5, dboutcome.getComputereply().getFlavourId());
                ps.setLong(6, computeServId);
                ps.setString(7, dboutcome.getComputereply().getComputeName());
                ps.setString(8, dboutcome.getComputereply().getOperationalState());
                ps.setString(9, dboutcome.getComputereply().getHostId());
                //FIX the Exception
                // ps.setObject(10,dboutcome.getVIMElem().getAccelerationCapability());
                ps.executeUpdate();

                //ResultSet rs = ps.getGeneratedKeys();
//                if (rs != null && rs.next()) {
//                    virtualcomputeId = rs.getLong(1);
//                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> computeServId:" + computeServId + "");
//                }
                virtualcomputeId = computeServId;

                //rs.close();
                ps.close();

                // START - Insert record in VirtualCPU table 
                VirtualComputeVirtualCpu virtualCpu = dboutcome.getComputereply().getVirtualCpu();
                if (virtualCpu != null) {

                    PreparedStatement ps_virtualCpu = conn.prepareStatement("INSERT INTO virtualcpu "
                            + "(cpuArchitecture,"
                            + "numVirtualCpu,"
                            + "cpuClock,"
                            + "virtualCpuOversubscriptionPolicy, "
                            + "computeServiceId) "
                            + "VALUES(?,?,?,?,?)");

                    ps_virtualCpu.setString(1, virtualCpu.getCpuArchitecture());
                    ps_virtualCpu.setInt(2, virtualCpu.getNumVirtualCpu());
                    ps_virtualCpu.setBigDecimal(3, virtualCpu.getCpuClock());
                    ps_virtualCpu.setString(4, virtualCpu.getVirtualCpuOversubscriptionPolicy());
                    ps_virtualCpu.setLong(5, computeServId);

                    ps_virtualCpu.executeUpdate();
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> VirtualCpu entry inserted into DB");
                    ps_virtualCpu.close();

                }

                // START - Insert record in VirtualCpuPinning table 
                CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning pinning = dboutcome.getComputereply().getVirtualCpu().getVirtualCpuPinning();
                if (pinning != null) {
                    if (pinning.getCpuPinningRules() != null && pinning.getCpuMap() != null && pinning.getCpuPinningPolicy() != null) {

                        PreparedStatement ps_pinning = conn.prepareStatement("INSERT INTO virtualcpupinning "
                                + "(cpuPinningPolicy,"
                                + "cpuPinningRules,"
                                + "cpuMap,"
                                + "computeServiceId) "
                                + "VALUES(?,?,?,?)");

                        ps_pinning.setString(1, pinning.getCpuPinningPolicy());
                        ps_pinning.setString(2, pinning.getCpuPinningRules());
                        ps_pinning.setString(3, pinning.getCpuMap());
                        ps_pinning.setLong(4, computeServId);

//ps_virtualCpu.setString(5, virtualCpu.getVirtualCpuPinning());
                        ps_pinning.executeUpdate();
                        System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> VirtualCpuPinning entry inserted into DB");
                        ps_pinning.close();
                    }
                }

                // START - Insert record in VirtualNetworkInterface table
                List<ReservedVirtualComputeVirtualisationContainerReservedVirtualNetworkInterface> networkInterfaceList = dboutcome.getComputereply().getVirtualNetworkInterface();

                if (networkInterfaceList != null) {
                    long size = networkInterfaceList.size();
                    for (int i = 0; i < size; i++) {
                        ReservedVirtualComputeVirtualisationContainerReservedVirtualNetworkInterface networkInterface = networkInterfaceList.get(i);
                        PreparedStatement ps_networkInterface = conn.prepareStatement("INSERT INTO virtualnetworkinterface (resourceId,ownerId,networkId,networkPortId,ipAddress,typeVirtualNic,typeConfiguration,macAddress,bandwidth,accelerationCapability,operationalState,metadata,ComputeServiceId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                        ps_networkInterface.setString(1, networkInterface.getResourceId());
                        ps_networkInterface.setString(2, networkInterface.getOwnerId());
                        ps_networkInterface.setString(3, networkInterface.getNetworkId());
                        ps_networkInterface.setString(4, networkInterface.getNetworkPortId());
                        ps_networkInterface.setString(5, networkInterface.getIpAddress());
                        ps_networkInterface.setString(6, networkInterface.getTypeVirtualNic());
                        ps_networkInterface.setString(7, networkInterface.getTypeConfiguration());
                        ps_networkInterface.setString(8, networkInterface.getMacAddress());
                        ps_networkInterface.setString(9, networkInterface.getBandwidth());
                        ps_networkInterface.setString(10, networkInterface.getAccelerationCapability());
                        ps_networkInterface.setString(11, networkInterface.getOperationalState());
                        ps_networkInterface.setString(12, networkInterface.getMetadata());
                        ps_networkInterface.setLong(13, computeServId);

                        ps_networkInterface.executeUpdate();
                        System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> VirtualNetworkInterface entry inserted into DB");
                        ps_networkInterface.close();

                    }

                }

                // START - Insert record in VirtualMemory table 
                VirtualComputeVirtualMemory memory = dboutcome.getComputereply().getVirtualMemory();

                if (memory != null) {

                    PreparedStatement ps_memory = conn.prepareStatement("INSERT INTO virtualmemory "
                            + "(virtualMemSize,"
                            + "virtualMemOversubscriptionPolicy,"
                            + "numaEnabled,"
                            + "computeServiceId) VALUES(?,?,?,?)");
                    ps_memory.setBigDecimal(1, memory.getVirtualMemSize());
                    ps_memory.setString(2, memory.getVirtualMemOversubscriptionPolicy());
                    ps_memory.setBoolean(3, memory.isNumaEnabled());
                    ps_memory.setLong(4, computeServId);

                    ps_memory.executeUpdate();
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> VirtualMemory entry inserted into DB");
                    ps_memory.close();

                }

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            // END - Insert

            // Retrieve from AllocateRaquest the computeFlavourId and the abstrResourceZoneId (mapped on IFA005 locationConstraints and computeFlavourId attributes, respectively)
            //NOTE that computeFlavourId and the ResourceZoneId may be obtained from VirtualCompute table
            String computeFlavourId = dboutcome.getComputerequest().getComputeFlavourId();
            String abstrResourceZoneId = dboutcome.getComputerequest().getLocationConstraints();
            System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> ComputeFlavourId: " + computeFlavourId + "");
            System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> AbstrResourceZoneId: " + abstrResourceZoneId + "");

//Amount of CPU released from the Capacity related to the couple (nfviPoP, zoneId)
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT numVirtualCpu FROM virtualcpu where computeFlavourId=?");
                ps.setString(1, computeFlavourId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    numVirtualCpu = rs.getLong("numVirtualCpu");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> numVirtualCpu: " + numVirtualCpu + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Amount of Memory released from the Capacity related to the couple (nfviPoP, zoneId)
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT virtualMemSize FROM `mtpdomdb`.`virtualmemorydata` where computeFlavourId=?");
                ps.setString(1, computeFlavourId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    memorySize = rs.getLong("virtualMemSize");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> virtualMemSize: " + memorySize + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Amount of Storage released from the Capacity related to the couple (nfviPoP, zoneId)
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT sizeOfStorage FROM virtualstoragedata where computeFlavourId=?");
                ps.setString(1, computeFlavourId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    storageSize = rs.getLong("sizeOfStorage");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> sizeOfStorage: " + storageSize + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Set the ZoneId. Assumption: 1 to 1 Mapping between ZoneId and AbstrZoneId
            zoneId = abstrResourceZoneId;

//Update memory capacity in Domain DB
            try {
                long availableMemCapacity;
                long allocatedMemCapacity;
                long currentAvailableMemCapacity;
                long currentAllocatedMemCapacity;
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                // INNER JOIN SELECT QUERY
                //PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity from memoryresources inner join zoneid on zoneid.NfviPopId=? where memoryresources.resourceZoneId=zoneid.resourceZoneId");
                //STANDARD SELECT QUERY
                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, resourceZoneId from memoryresources where memoryresources.resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, zoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableMemCapacity = rs.getLong("availableCapacity");
                    allocatedMemCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableMemCapacity = availableMemCapacity - memorySize;
                    currentAllocatedMemCapacity = allocatedMemCapacity + memorySize;
                    rs.updateLong("availableCapacity", availableMemCapacity - memorySize);
                    rs.updateLong("allocatedCapacity", allocatedMemCapacity + memorySize);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> Memory capacity updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> Old available  memory capacity " + availableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> Current available  memory capacity " + currentAvailableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> Old allocated  memory capacity " + allocatedMemCapacity + "");
                    System.out.println("DatabaseDriver.handle__ComputeAllocateDBQueryOutcome ---> Current allocated memory capacity " + currentAllocatedMemCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update memory capacity in Abstraction DB
            try {
                long availableMemCapacity;
                long allocatedMemCapacity;
                long currentAvailableMemCapacity;
                long currentAllocatedMemCapacity;
                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, abstrResourceZoneId from abstrmemoryresources where abstrResourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, abstrResourceZoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableMemCapacity = rs.getLong("availableCapacity");
                    allocatedMemCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableMemCapacity = availableMemCapacity - memorySize;
                    currentAllocatedMemCapacity = allocatedMemCapacity + memorySize;
                    rs.updateLong("availableCapacity", currentAvailableMemCapacity);
                    rs.updateLong("allocatedCapacity", currentAllocatedMemCapacity);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Memory capacity updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old available  memory capacity " + availableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current available  memory capacity " + currentAvailableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old allocated  memory capacity " + allocatedMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current allocated memory capacity " + currentAllocatedMemCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update storage capacity in Domain DB
            try {
                long availableStorageCapacity;
                long allocatedStorageCapacity;
                long currentAvailableStorageCapacity;
                long currentAllocatedStorageCapacity;
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, resourceZoneId from storageresources where resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, zoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableStorageCapacity = rs.getLong("availableCapacity");
                    allocatedStorageCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableStorageCapacity = availableStorageCapacity - storageSize;
                    currentAllocatedStorageCapacity = allocatedStorageCapacity + storageSize;
                    rs.updateLong("availableCapacity", currentAvailableStorageCapacity );
                    rs.updateLong("allocatedCapacity", currentAllocatedStorageCapacity);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Memory capacity updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old available storage capacity " + availableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current available storage capacity " + currentAvailableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old allocated storage capacity " + allocatedStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current allocated storage capacity " + currentAllocatedStorageCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update storage capacity in Abstraction DB
            try {
                long availableStorageCapacity;
                long allocatedStorageCapacity;
                long currentAvailableStorageCapacity;
                long currentAllocatedStorageCapacity;
                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, abstrResourceZoneId from abstrstorageresources where abstrResourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, abstrResourceZoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableStorageCapacity = rs.getLong("availableCapacity");
                    allocatedStorageCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableStorageCapacity = availableStorageCapacity - storageSize;
                    currentAllocatedStorageCapacity = allocatedStorageCapacity + storageSize;
                    rs.updateLong("availableCapacity", currentAvailableStorageCapacity);
                    rs.updateLong("allocatedCapacity", currentAllocatedStorageCapacity);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Memory capacity updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old available  storage capacity " + availableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current available  storage capacity " + currentAvailableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old allocated  storagecapacity " + allocatedStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current allocated storage capacity " + currentAllocatedStorageCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update CPU capacity in Domain DB
            try {
                long availableCpuCapacity;
                long allocatedCpuCapacity;
                long currentAvailableCpuCapacity;
                long currentAllocatedCpuCapacity;
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                // INNER JOIN SELECT QUERY
                //PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity from memoryresources inner join zoneid on zoneid.NfviPopId=? where memoryresources.resourceZoneId=zoneid.resourceZoneId");
                //STANDARD SELECT QUERY
                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, resourceZoneId from cpuresources where resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, zoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableCpuCapacity = rs.getLong("availableCapacity");
                    allocatedCpuCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableCpuCapacity = availableCpuCapacity - numVirtualCpu;
                    currentAllocatedCpuCapacity = allocatedCpuCapacity + numVirtualCpu;
                    rs.updateLong("availableCapacity", availableCpuCapacity - numVirtualCpu);
                    rs.updateLong("allocatedCapacity", allocatedCpuCapacity + numVirtualCpu);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> CPU capacity updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old available cpu capacity " + availableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current available cpu capacity " + currentAvailableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old allocated cpu capacity " + allocatedCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current allocated cpu capacity " + currentAllocatedCpuCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update CPU capacity in Abstraction DB
            try {
                long availableCpuCapacity;
                long allocatedCpuCapacity;
                long currentAvailableCpuCapacity;
                long currentAllocatedCpuCapacity;
                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, abstrResourceZoneId from abstrcpuresources where abstrResourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, abstrResourceZoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableCpuCapacity = rs.getLong("availableCapacity");
                    allocatedCpuCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableCpuCapacity = availableCpuCapacity - numVirtualCpu;
                    currentAllocatedCpuCapacity = allocatedCpuCapacity + numVirtualCpu;
                    rs.updateLong("availableCapacity", currentAvailableCpuCapacity);
                    rs.updateLong("allocatedCapacity", currentAllocatedCpuCapacity);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Memory capacity updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old available cpu capacity " + availableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current available cpu capacity " + currentAvailableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Old allocated cpu capacity " + allocatedCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeAllocateDBQueryOutcome ---> Current allocated cpu capacity " + currentAllocatedCpuCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

//    // START - Update outcome attribute in computeServiceRequestData table
//          try {
//            
//    java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
//
//           
//            PreparedStatement ps = conn.prepareStatement("UPDATE computeservices SET outcome=? WHERE computeServiceId=?");
//            // PreparedStatement ps = conn.prepareStatement("UPDATE computeservices SET vnfName=? WHERE computeServiceId=?");
//            
//            ps.setBoolean(1,dboutcome.getOutcome());
//           //ps.setString(1,"test");
//            ps.setLong(2,dboutcome.getComputeserviceid());
//        
//            
//            ps.executeUpdate();
//
//            ps.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseDriver.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        // END - Update
//        
        }
        //update the virtualcompute with the virtualcomute id to provide to SO 
        dboutcome.getComputereply().setComputeId(Long.toString(virtualcomputeId));
        E2EComputeAllocateInstanceOutcome allinst = new E2EComputeAllocateInstanceOutcome(dboutcome.getReqid(),
                dboutcome.getServid(), dboutcome.getComputereply(), dboutcome.isOutcome());
        System.out.println("DatabaseDriver --> Post E2EComputeAllocateInstanceOutcome Event");
        SingletonEventBus.getBus().post(allinst);

    }

    @Subscribe
    public void handle_NetworkAllocateDBQuery(NetworkAllocateDBQuery dbquery) {
        System.out.println("DatabaseDriver ---> Handle NetworkAllocateDBQuery Event");
        long logicalPathId = dbquery.getLogicalpath();
        ArrayList<Long> interdomainLinks = new ArrayList();
        ArrayList<Long> intraPopLinks = new ArrayList();
        ArrayList<Long> wanLinks = new ArrayList();
        ArrayList<Long> wimPopList = new ArrayList();
        ArrayList<Long> vimPopList = new ArrayList();
        ArrayList<Long> wimdomlist = new ArrayList();
        ArrayList<Long> vimdomlist = new ArrayList();
        ArrayList<String> wimNetworkType = new ArrayList();
        ArrayList<String> vimNetworkType = new ArrayList();
        long abstrSrcNfviPopId = -1;
        long abstrDestNfviPopId = -1;

        //TODO perform query in DB using JDBC
        // START - Insert servID into Service table
        try {

            java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO service (servId) VALUES(?)");
            ps.setLong(1, dbquery.getServid());

            ps.executeUpdate();
            ps.close();

        } catch (SQLIntegrityConstraintViolationException ex) {
//            Logger.getLogger(ResourceSelectionLogic.class
//                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("handle_NetworkAllocateDBQuery ---> SQLIntegrityConstraintViolationException: ServiceId is already in the DB");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
// END - Insert

        //Get from DB the interdomainLinks 
        try {
            java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT interDomainLinkId  FROM logicalpath_interdomainlink where logicalPathId=?");
            ps.setLong(1, logicalPathId);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                interdomainLinks.add(rs.getLong("interDomainLinkId"));

                System.out.println("handle_NetworkAllocateDBQuery ---> InterDomainLinkId: " + rs.getLong("InterDomainLinkId") + "");

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Get from DB the  wanLinks, wimPopList and networkType
        try {
            java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT logicalpath_networkresources.networkResId, logicalpath_networkresources.logicalPathId, networkresources.networkType, zoneid.nfviPopId, domain.type, domain.domId from logicalpath_networkresources \n"
                    + "INNER JOIN networkresources ON networkresources.networkResId=logicalpath_networkresources.networkResId\n"
                    + " INNER JOIN zoneid ON  networkresources.resourceZoneId=zoneid.resourceZoneId \n"
                    + "INNER JOIN nfvipop ON zoneid.nfviPopId = nfvipop.nfviPopId\n"
                    + "INNER JOIN domain ON nfvipop.domId = domain.domId\n"
                    + "where logicalpath_networkresources.logicalPathId=?");

            ps.setLong(1, logicalPathId);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String type = rs.getString("type");
//                if (type.equals("VIM")) {
//                    intraPopLinks.add(rs.getLong("networkResId"));
//                    vimPopList.add(rs.getLong("nfviPopId"));
//                    vimdomlist.add(rs.getLong("domId"));
//                    vimNetworkType.add(rs.getString("networkType"));
//                    System.out.println("handle_NetworkAllocateDBQuery ---> IntraPopLink - NetworkResId: " + rs.getLong("NetworkResId") + "");
//                }

                if (type.equals("T-WIM")) {
                    wanLinks.add(rs.getLong("networkResId"));
                    wimPopList.add(rs.getLong("nfviPopId"));
                    wimdomlist.add(rs.getLong("domId"));
                    wimNetworkType.add(rs.getString("networkType"));
                    System.out.println("handle_NetworkAllocateDBQuery ---> WanLink - NetworkResId: " + rs.getLong("NetworkResId") + "");
                }

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Get from logicalpath table the abstrSrcNfviPop and abstrDstNfviPop to request intraPop connectivities
        try {
            java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT abstrSrcNfviPopId, abstrDestNfviPopId  FROM logicalpath where logicalPathId=?");
            ps.setLong(1, logicalPathId);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                abstrSrcNfviPopId = rs.getLong("abstrSrcNfviPopId");
                abstrDestNfviPopId = rs.getLong("abstrDestNfviPopId");

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Get from DB the vimPoP and vimDomain related to the abstrSrcNfviPop 
        try {
            java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT nfvipop.nfviPopId, domain.domId from nfvipop INNER JOIN domain ON domain.domId=nfvipop.domId where nfvipop.abstrNfviPopId=?");

            ps.setLong(1, abstrSrcNfviPopId);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                vimPopList.add(rs.getLong("nfviPopId"));
                vimdomlist.add(rs.getLong("domId"));

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Get from DB the vimPoP and vimDomain related to the abstrDestNfviPop 
        try {
            java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT nfvipop.nfviPopId, domain.domId from nfvipop INNER JOIN domain ON domain.domId=nfvipop.domId where nfvipop.abstrNfviPopId=?");

            ps.setLong(1, abstrDestNfviPopId);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                vimPopList.add(rs.getLong("nfviPopId"));
                vimdomlist.add(rs.getLong("domId"));

            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        //NetworkAllocateDBQueryReply dbreply = new NetworkAllocateDBQueryReply(dbquery.getReqId(), dbquery.getServId());
        NetworkAllocateDBQueryReply dbreply = new NetworkAllocateDBQueryReply(dbquery.getReqid(), dbquery.getServid(),
                logicalPathId, wimdomlist, vimdomlist, interdomainLinks, intraPopLinks, wanLinks, wimPopList, vimPopList, wimNetworkType,
                vimNetworkType);

        System.out.println("DatabaseDriver ---> Post NetworkAllocateDBQueryReply Event");
        SingletonEventBus.getBus().post(dbreply);

    }

    @Subscribe
    public void handle_NetworkAllocateDBQueryOutcome(NetworkAllocateDBQueryOutcome dboutcome) {
        System.out.println("DatabaseDriver ---> Handle NetworkAllocateDBQueryOutcome Event");

        if (dboutcome.isOutcome() == false) {
            //send API reply with void virtualcompute Instance

            E2ENetworkAllocateInstanceOutcome netneginst = new E2ENetworkAllocateInstanceOutcome(dboutcome.getReqid(),
                    dboutcome.getServid(), null, dboutcome.isOutcome(), dboutcome.getLogicalPathId());
            System.out.println("DatabaseDriver --> Post E2ENetworkAllocateInstanceOutcome  Negative outcome Event");
            SingletonEventBus.getBus().post(netneginst);
            return;
        }

        long networkServId = -1;
        long virtualnetworkId = -1;

        // Insert record in networkservices table//
        try {

            java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO networkservices "
                    + "(reqId,"
                    + "status,"
                    + "servId,"
                    + "logicalPathId)"
                    + "VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1, dboutcome.getReqid());
            ps.setString(2, "enabled");
            ps.setLong(3, dboutcome.getServid());
            ps.setLong(4, dboutcome.getLogicalPathId());
            //ps.setString(5,null);

            ps.executeUpdate();
            System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> NetworkService instance inserted into DB");
            ResultSet rs = ps.getGeneratedKeys();

            if (rs != null && rs.next()) {
                networkServId = rs.getLong(1);
                System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> netServId:" + networkServId + "");
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        //END - Insert      
        //START - Insert virtualnetwork entries for WIM POPs 
        List<VirtualNetwork> wimlist = dboutcome.getWimnetlist();

        // while (computeIdList|=null){
        for (int i = 0; i < dboutcome.getWimnetlist().size(); i++) {

            try {
                //String computeServId=computeIdList.remove(0).getNetworkId();
                VirtualNetwork vn = wimlist.get(i);

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO mtpservdb.virtualnetwork\n"
                        + "(networkResourceName,"
                        + "segmentType,"
                        + "isShared,"
                        + "zoneId,"
                        + "networkResourceId,"
                        + "networkType,"
                        + "operationalState,"
                        + "sharingCriteria,"
                        + "bandwidth,"
                        + "nfviPopId,"
                        + "netServId,"
                        + "netResIdRef)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, vn.getNetworkResourceName());
                ps.setString(2, vn.getSegmentType());
                ps.setBoolean(3, vn.isIsShared());
                ps.setString(4, vn.getZoneId());
                ps.setString(5, vn.getNetworkResourceId());
                ps.setString(6, vn.getNetworkType());
                ps.setString(7, vn.getOperationalState());
                ps.setString(8, vn.getSharingCriteria());
                ps.setBigDecimal(9, vn.getBandwidth());
                ps.setLong(10, dboutcome.getWimPopList().get(i));
                ps.setLong(11, networkServId);
                ps.setLong(12, dboutcome.getWanLinks().get(i));

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> VirtualNetwork instance inserted into DB");
                ResultSet rs = ps.getGeneratedKeys();

                if (rs != null && rs.next()) {
                    virtualnetworkId = rs.getLong(1);
                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> netServId:" + networkServId + "");
                }
                rs.close();
                ps.close();
                //Insert entries in NETWORK_SUBSET table
                // TO DO - Fix this part after the VirtualNetwork class is compliant with IFA005 
                if (vn.getSubnet() != null) {
                    PreparedStatement ps_subnet = conn.prepareStatement("INSERT INTO networksubnet"
                            + "(resourceId,virtualNetworkId) VALUES(?,?)");
//UNCOMMENT after  NETWORK_SUBSET class is fixed
//                    ps_subnet.setString(1,vn.getSubnet());
//                    ps_subnet.setLong(2,virtualnetworkId);
                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> Subnet entry inserted into DB");
                    ps_subnet.close();
                }
//Insert entries in VIRTUAL_NETWORK_PORT table
                //TO DO - Complete after VIRTUAL_NETWORK_PORT class is fixed (related to IFA005) 
                if (vn.getNetworkPort() != null) {

                    for (int j = 0; j < vn.getNetworkPort().size(); j++) {

                        PreparedStatement ps_port = conn.prepareStatement("INSERT INTO virtualnetworkport "
                                + "(resourceId, portType,attachedResourceId,segmentId,bandwidth,metadata,virtualNetworkId)"
                                + "VALUES(?,?,?,?,?,?,?)");

                        ps_port.setString(1, vn.getNetworkPort().get(j).getResourceId());
                        ps_port.setString(2, vn.getNetworkPort().get(j).getPortType());
                        ps_port.setString(3, vn.getNetworkPort().get(j).getAttachedResourceId());
                        //TO DO - Insert below attributes when VIRTUAL_NETWORK_PORT class is fixed (related to IFA005)                  
                        // ps_port.setString(4,vn.getNetworkPort().get(j).);
                        // ps_port.setString(5,vn.getNetworkPort().get(j).);
                        //  ps_port.setString(6,vn.getNetworkPort().get(j).);
                        ps_port.setLong(7, virtualnetworkId);
                        System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> VirtualNetworkPort entry inserted into DB");
                        ps_port.close();
                    }
                }
                //Insert entries in Network_QoS table
                //TO DO - Complete after VIRTUAL_NETWORK class is fixed (related to IFA005) 
                // UNCOMMENT after  VIRTUAL_NETWORK class is fixed 
//                if(vn.getNetworkQoS()!=null) {
//
//                     for (int j = 0; j < vn.getNetworkPort().size(); j++) {
//                    PreparedStatement ps_qos = conn.prepareStatement(" INSERT INTO supportednetworkqos\n" +
//"(qosName, qosValue, virtualnetworkId)\n" +
//"VALUES (?,?,?);");
//
//                    ps_qos.setString(1,vn.getNetworkQoS().get(j).); 
//                    ps_qos.setString(1,vn.getNetworkQoS().get(j).);
//                    ps_qos.setLong(3,virtualnetworkId);
//                    
//                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> Network QoS entry inserted into DB");
//                    ps_qos.close();
//                     }      
//                }  
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        //START - Insert virtualnetwork entries for VIM POPs 
        List<VirtualNetwork> vimlist = dboutcome.getVimnetlist();

        // while (computeIdList!=null){
        for (int i = 0; i < dboutcome.getVimnetlist().size(); i++) {

            try {
                //String computeServId=computeIdList.remove(0).getNetworkId();
                VirtualNetwork vn = vimlist.get(i);

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO mtpservdb.virtualnetwork\n"
                        + "(networkResourceName,"
                        + "segmentType,"
                        + "isShared,"
                        + "zoneId,"
                        + "networkResourceId,"
                        + "networkType,"
                        + "operationalState,"
                        + "sharingCriteria,"
                        + "bandwidth,"
                        + "nfviPopId,"
                        + "netServId)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, vn.getNetworkResourceName());
                ps.setString(2, vn.getSegmentType());
                ps.setBoolean(3, vn.isIsShared());
                ps.setString(4, vn.getZoneId());
                ps.setString(5, vn.getNetworkResourceId());
                ps.setString(6, vn.getNetworkType());
                ps.setString(7, vn.getOperationalState());
                ps.setString(8, vn.getSharingCriteria());
                ps.setBigDecimal(9, vn.getBandwidth());
                ps.setLong(10, dboutcome.getVimPopList().get(i));
                ps.setLong(11, networkServId);

                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> VirtualNetwork instance inserted into DB");
                ResultSet rs = ps.getGeneratedKeys();

                if (rs != null && rs.next()) {
                    virtualnetworkId = rs.getLong(1);
                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> netServId:" + networkServId + "");
                }
                rs.close();
                ps.close();
                //Insert entries in NETWORK_SUBSET table
                // TO DO - Fix this part after the VirtualNetwork class is compliant with IFA005 
                if (vn.getSubnet() != null) {

                    PreparedStatement ps_subnet = conn.prepareStatement("INSERT INTO networksubnet"
                            + "(resourceId,virtualNetworkId) VALUES(?,?)");
//UNCOMMENT after  NETWORK_SUBSET class is fixed
//                    ps_subnet.setString(1,vn.getSubnet());
//                    ps_subnet.setLong(2,virtualnetworkId);
                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> Subnet entry inserted into DB");
                    ps_subnet.close();
                }
//Insert entries in VIRTUAL_NETWORK_PORT table
                //TO DO - Complete after VIRTUAL_NETWORK_PORT class is fixed (related to IFA005) 
                if (vn.getNetworkPort() != null) {

                    for (int j = 0; j < vn.getNetworkPort().size(); j++) {

                        PreparedStatement ps_port = conn.prepareStatement("INSERT INTO virtualnetworkport "
                                + "(resourceId, portType,attachedResourceId,segmentId,bandwidth,metadata,virtualNetworkId)"
                                + "VALUES (?,?,?,?,?,?,?)");

                        ps_port.setString(1, vn.getNetworkPort().get(j).getResourceId());
                        ps_port.setString(2, vn.getNetworkPort().get(j).getPortType());
                        ps_port.setString(3, vn.getNetworkPort().get(j).getAttachedResourceId());
                        //TO DO - Insert below attributes when VIRTUAL_NETWORK_PORT class is fixed (related to IFA005)                  
                        // ps_port.setString(4,vn.getNetworkPort().get(j).);
                        // ps_port.setString(5,vn.getNetworkPort().get(j).);
                        //  ps_port.setString(6,vn.getNetworkPort().get(j).);
                        ps_port.setLong(7, virtualnetworkId);
                        System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> VirtualNetworkPort entry inserted into DB");
                        ps_port.close();
                    }
                }
                //Insert entries in Network_QoS table
                //TO DO - Complete after VIRTUAL_NETWORK class is fixed (related to IFA005) 
                // UNCOMMENT after  VIRTUAL_NETWORK class is fixed 
//                if(vn.getNetworkQoS()!=null) {
//
//                     for (int j = 0; j < vn.getNetworkPort().size(); j++) {
//                    PreparedStatement ps_qos = conn.prepareStatement(" INSERT INTO supportednetworkqos\n" +
//"(qosName, qosValue, virtualnetworkId)\n" +
//"VALUES (?,?,?);");
//
//                    ps_qos.setString(1,vn.getNetworkQoS().get(j).); 
//                    ps_qos.setString(1,vn.getNetworkQoS().get(j).);
//                    ps_qos.setLong(3,virtualnetworkId);
//                    
//                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> Network QoS entry inserted into DB");
//                    ps_qos.close();
//                     }      
//                }  
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

      //  START - INSERT AllocateNetworkRequest into DB
      InterNfviPopConnectivityRequest allocNetworkReq = dboutcome.getNetworkRequest();

        try {

            java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

            // Insert  data into computeservicerequestdata table
            PreparedStatement ps = conn.prepareStatement("INSERT INTO networkservicerequestdata\n"
                    + "(networkResourceType,"
                    + "netServId)"
                    + "VALUES (?,?)");

            ps.setString(1, allocNetworkReq.getNetworkLayer());
            ps.setLong(2, networkServId);
            ps.executeUpdate();
            System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> AllocateNetworkRequest data inserted into DB");
            ps.close();

            // Insert  data into VIRTUAL_NETWORK_DATA table
                // if (networkdata!=null) {

                        PreparedStatement ps_netdata = conn.prepareStatement("INSERT INTO virtualnetworkdata "
                                + "(bandwidth, "
                                + "networkType,"
                                + "netServId) VALUES(?,?,?)");
                        
                        //TO DO - Add missing paramenters
                        ps_netdata.setLong(1, allocNetworkReq.getReqBandwidth().longValue());
                        ps_netdata.setString(2, allocNetworkReq.getInterNfviPopNetworkType());
                        ps_netdata.setLong(3, networkServId);
                        ps_netdata.executeUpdate();
                        System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> VirtualNetworkData record inserted into DB");
                        ps_netdata.close();
         //       }
// Insert  data into NETWORK_QoS table
                //List <Object> qosList = networkdata.getQos();
                
                 //  if (qosList!=null) {

                  //  for (int j = 0; j < qosList.size(); j++) {

            PreparedStatement ps_qos = conn.prepareStatement("INSERT INTO networkqos"
                    + "(qosName,"
                    + "qosValue,"
                    + "netServId)"
                    + "VALUES (?,?,?)");

                        //TO DO - Add missing attributes
                       ps_qos.setString(1, "delay");
                       ps_qos.setBigDecimal(2, dboutcome.getNetworkRequest().getReqLatency());
                       ps_qos.setLong(3, networkServId);
                       ps_qos.executeUpdate();
                       System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> QoS entry inserted into DB");
                       ps_qos.close();
                 //   }
               // }
            //Insert  data into LAYER3_CONNECTIVITY_INFORMATION table
            // TO DO - Complete this part after Allocate Virtualised Network Resource operation input parameters are fixed
            //UNCOMMENT after Allocate Virtualised Network Resource operation input parameters are fixed
//List <Object> layer3InfoList = networkdata.getLayer3();      
//                   if (layer3InfoList!=null) {
//
//                    for (int j = 0; j < layer3InfoList.size(); j++) {
//
//                        PreparedStatement ps_layer3 = conn.prepareStatement("INSERT INTO layer3connectivityinformation\n" +
//"(networkId, ipVersion, gatewayIp, cidr, isDhcpEnabled, addressPool, metadata, netServId)\n" +
//"VALUES(?,?,?,?,?,?,?,?)");
//        
//                        
//                        //TO DO - Add missing attributes
//                        ps_layer3.setString(1, layer3InfoList.get(j).getQosName());
//                      
//                        ps_layer3.setLong(8, virtualnetworkId);
//                        System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> QoS entry inserted into DB");
//                        ps_layer3.close();
//                    }
//                }
            // Insert  data into VIRTUAL_NETWORK_PORT_DATA table
            // TO DO - Complete this part after Allocate Virtualised Network Resource operation input parameters are fixed
            //UNCOMMENT after Allocate Virtualised Network Resource operation input parameters are fixed
//                Object portdata = allocNetworkReq.getTypeNetworkPortData();
//                if (portdata!= null) {
//
//                        PreparedStatement ps_portdata = conn.prepareStatement("INSERT INTO virtualnetworkportdata "
//                                + "(portType, networkId, segmentId, bandwidth, metadata, netServId)\n" +
//                                  "VALUES(?,?,?,?,?,?)");
//   
//                        ps_portdata.setString(1, portdata.get));  
//                        ps_portdata.setLong(6, networkServId);
//                      
//                        ps_portdata.executeUpdate();
//                        System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> VirtualNetworkPortData record inserted into DB");
//                        ps_portdata.close();       
//                }
            // Insert  data into NETWORK_SUBNET_DATA table
            // TO DO - Complete this part after Allocate Virtualised Network Resource operation input parameters are fixed
            //UNCOMMENT after Allocate Virtualised Network Resource operation input parameters are fixed
//                Object subnetData = allocNetworkReq.getTypeSubnetData();
//                if (subnetData != null) {
// 
//                    PreparedStatement ps_subnetData = conn.prepareStatement("INSERT INTO networksubnetdata\n" +
//"(networkId, ipVersion, gatewayIp, cidr, isDhcpEnabled, addressPool, metadata, netServId) \n" +
//"VALUES (?,?,?,?,?,?,?,?)");
//                    //TO DO - Complete this part after Allocate Virtualised Network Resource operation input parameters are fixed
//                    ps_subnetData.setString(1, subnetData.get);
//                
//                    ps_subnetData.setLong(8, networkServId);
//
//                    ps_subnetData.executeUpdate();
//                    System.out.println("DatabaseDriver.handle_NetworkAllocateDBQueryOutcome ---> NetworkSubnetData record inserted into DB");
//                    ps_subnetData.close();
//
//                }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
//END - Insert





        //Amount of Bandwidth released from the Capacity
long bandwidth = dboutcome.getNetworkRequest().getReqBandwidth().longValue();
//long  bandwidth = 5000000;


//Update Capacity in logicalpath table
        try {
            long availableBandwidth;
            long allocatedBandwidth;
            long currentAvailableBandwidth;
            long currentAllocatedBandwidth;

            java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT logicalPathId, availableBandwidth, reservedBandwidth,"
                    + " totalBandwidth, allocatedBandwidth\n"
                    + "FROM logicalpath WHERE logicalPathId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ps.setLong(1, dboutcome.getLogicalPathId());
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                availableBandwidth = rs.getLong("availableBandwidth");
                allocatedBandwidth = rs.getLong("allocatedBandwidth");
                currentAvailableBandwidth = availableBandwidth - bandwidth;
                currentAllocatedBandwidth = allocatedBandwidth + bandwidth;
                rs.updateLong("availableBandwidth", currentAvailableBandwidth);
                rs.updateLong("allocatedBandwidth", currentAllocatedBandwidth);
                rs.updateRow();

                System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Bandwidth updated in Abstraction_DB!");
                System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
                System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
                System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
                System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDriver.class
                    .getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
//START - Update Capacity in Domain DB

//Update InterDomainLinks capacity
        for (int i = 0; i < dboutcome.getInterdomainLinks().size(); i++) {

            try {
                long availableBandwidth;
                long allocatedBandwidth;
                long currentAvailableBandwidth;
                long currentAllocatedBandwidth;

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("SELECT interDomainLinkId, availableBandwidth, reservedBandwidth, "
                        + "totalBandwidth, allocatedBandwidth\n"
                        + "FROM interdomainlink WHERE interDomainLinkId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, dboutcome.getInterdomainLinks().get(i));
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableBandwidth = rs.getLong("availableBandwidth");
                    allocatedBandwidth = rs.getLong("allocatedBandwidth");
                    currentAvailableBandwidth = availableBandwidth - bandwidth;
                    currentAllocatedBandwidth = allocatedBandwidth + bandwidth;
                    rs.updateLong("availableBandwidth", currentAvailableBandwidth);
                    rs.updateLong("allocatedBandwidth", currentAllocatedBandwidth);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Bandwidth updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

//        //Update IntraPopLinks capacity
//        for (int i = 0; i < dboutcome.getIntraPopLinks().size(); i++) {
//
//            try {
//                long availableBandwidth;
//                long allocatedBandwidth;
//                long currentAvailableBandwidth;
//                long currentAllocatedBandwidth;
//
//                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
//
//                PreparedStatement ps = conn.prepareStatement("SELECT networkResId, availableCapacity, reservedCapacity, totalCapacity, "
//                        + "allocatedCapacity, networkResourceTypeId\n"
//                        + "FROM networkresources WHERE networkResId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//                ps.setLong(1, dboutcome.getIntraPopLinks().get(i));
//                java.sql.ResultSet rs = ps.executeQuery();
//                while (rs.next()) {
//                    availableBandwidth = rs.getLong("availableCapacity");
//                    allocatedBandwidth = rs.getLong("allocatedCapacity");
//                    currentAvailableBandwidth = availableBandwidth - bandwidth;
//                    currentAllocatedBandwidth = allocatedBandwidth + bandwidth;
//                    rs.updateLong("availableCapacity", currentAvailableBandwidth);
//                    rs.updateLong("allocatedCapacity", currentAllocatedBandwidth);
//                    rs.updateRow();
//
//                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Bandwidth updated in DOMAIN_DB!");
//                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
//                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
//                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
//                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
//                }
//
//                rs.close();
//                ps.close();
//
//            } catch (SQLException ex) {
//                Logger.getLogger(DatabaseDriver.class
//                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//        }
        //Update WanLinks capacity
        for (int i = 0; i < dboutcome.getWanLinks().size(); i++) {

            try {
                long availableBandwidth;
                long allocatedBandwidth;
                long currentAvailableBandwidth;
                long currentAllocatedBandwidth;

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("SELECT networkResId, availableCapacity, reservedCapacity, totalCapacity, "
                        + "allocatedCapacity, networkResourceTypeId\n"
                        + "FROM networkresources WHERE networkResId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, dboutcome.getWanLinks().get(i));
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableBandwidth = rs.getLong("availableCapacity");
                    allocatedBandwidth = rs.getLong("allocatedCapacity");
                    currentAvailableBandwidth = availableBandwidth - bandwidth;
                    currentAllocatedBandwidth = allocatedBandwidth + bandwidth;
                    rs.updateLong("availableCapacity", currentAvailableBandwidth);
                    rs.updateLong("allocatedCapacity", currentAllocatedBandwidth);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Bandwidth updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkAllocateDBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        //END - Update Capacity in Domain DB
//TO DO - Refine the criterion to select the VirtualNetwork instance from the wanLinks
//Select the first VirtualNetwork instance in wanLinks and update
//it with the virtualnetworkId (networkServId) to provide to SO 
        VirtualNetwork vn = dboutcome.getWimnetlist().get(0);
        vn.setNetworkResourceId(Long.toString(networkServId));

//        E2ENetworkAllocateInstanceOutcome netinst = new E2ENetworkAllocateInstanceOutcome(dboutcome.getReqid(),
//                dboutcome.getServid(), /*Inset VN*/ null, dboutcome.isOutcome(), dboutcome.getLogicalPathId());
        E2ENetworkAllocateInstanceOutcome netinst = new E2ENetworkAllocateInstanceOutcome(dboutcome.getReqid(),
                dboutcome.getServid(), vn, dboutcome.isOutcome(), dboutcome.getLogicalPathId());

        System.out.println("DatabaseDriver --> Post E2ENetworkAllocateInstanceOutcome Event");
        SingletonEventBus.getBus().post(netinst);

    }

    //////////////////Terminate Event Handlers///////////////////////////////
    @Subscribe
    public void handle_ComputeTerminateDBQuery(ComputeTerminateDBQuery dbquery) {
        System.out.println("DatabaseDriver ---> Handle ComputeTerminateDBQuery Event");

        //START - Retrieve from DB the list of NfviPoP (PopId) where the compute resources to terminate are deployed as well as the
        //list of domains (domId) to call for compute resource termination 
        ArrayList<Long> domlist = new ArrayList();
        ArrayList<Long> poplist = new ArrayList();
        List<String> computeIdList = dbquery.getComputereq();

        long size = dbquery.getComputereq().size();

        // while (computeIdList!=null){
        for (int i = 0; i < size; i++) {

            try {
                //String computeServId=computeIdList.remove(0).getNetworkId();
                String computeServId = computeIdList.get(i);
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("select domId, mtpdomdb.nfvipop.nfviPopId from mtpdomdb.nfvipop inner join mtpservdb.computeservices\n"
                        + "on mtpservdb.computeservices.computeServiceId=?\n"
                        + "where mtpservdb.computeservices.nfviPopId=mtpdomdb.nfvipop.nfviPopId;");
                ps.setString(1, computeServId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    domlist.add(rs.getLong("domId"));
                    poplist.add(rs.getLong("nfviPopId"));
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> DomId: " + rs.getLong("domid") + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> PopId: " + rs.getLong("NfviPopId") + "");

                }
                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        //ComputeTerminateDBQueryReply dbreply = new ComputeTerminateDBQueryReply(dbquery.getReqId(), dbquery.getServId());
        ComputeTerminateDBQueryReply dbreply = new ComputeTerminateDBQueryReply(dbquery.getReqid(), dbquery.getServid(),
                domlist, poplist);
        System.out.println("DatabaseDriver ---> Post ComputeTerminateDBQueryReply Event");
        SingletonEventBus.getBus().post(dbreply);

    }

    @Subscribe
    public void handle_ComputeTerminateDBQueryOutcome(ComputeTerminateDBQueryOutcome dboutcome) {
        System.out.println("DatabaseDriver ---> Handle ComputeTerminateDBQueryOutcome Event");
        //Remove entry from ComputeServices, VirtualCompute ComputeRequestData, AffinityOrAntiaffinityConstrain,
        // VirtualInterfaceData, Userdata, VirtualNetworkInterface, VirtualCpuand VirtualMemory tables if the 
        //corresponding outcome is TRUE

        //   ArrayList <VIMAbstractElem> vimlist = new ArrayList();
        for (int i = 0; i < dboutcome.getComputeIdList().size(); i++) {

            String computeId = dboutcome.getComputeIdList().get(i);
            long computeServiceId = -1;
            long computeFlavourId = -1;
            long abstrResourceZoneId = -1;
            long zoneId = -1;
            long numVirtualCpu = -1;
            long memorySize = -1;
            long storageSize = -1;
            //long abstrPopId = dboutcome.getPoplist().get(i);
            long abstrPopId = -1;
            long popId = dboutcome.getPoplist().get(i);

            // Retrieve from DB the abstrNfviPopId related to the nfviPopId
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT abstrNfviPopId FROM nfvipop where nfviPopId=?");
                ps.setLong(1, popId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    abstrPopId = rs.getLong("abstrNfviPopId");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> nfviPopId: " + popId + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> abstrNfviPopId: " + abstrPopId + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Retrieve from DB the ComputeServiceId related to the computeId  
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT computeServiceId FROM virtualcompute where computeServiceId=?");
                ps.setString(1, computeId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    computeServiceId = rs.getLong("computeServiceId");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> ComputeServiceId: " + computeServiceId + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            // Retrieve from DB the computeFlavourId and the ResourceZoneId (mapped on IFA005 locationConstraints attribute)
            //from the ComputeServiceRequestData table. Note that the ResourceZoneId retrieved from ComputeServiceRequestData is an abstrResourceZoneId.
            //NOTE that computeFlavourId and the ResourceZoneId may be obtained from VirtualCompute table
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT computeFlavourId,locationConstraints FROM computeservicerequestdata where computeServiceId=?");
                ps.setLong(1, computeServiceId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    computeFlavourId = rs.getLong("computeFlavourId");
                    abstrResourceZoneId = rs.getLong("locationConstraints");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> ComputeFlavourId: " + computeFlavourId + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> ZoneId: " + zoneId + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Set the ZoneId. Assumption: 1 to 1 Mapping between ZoneId and AbstrZoneId
            zoneId = abstrResourceZoneId;

            //Amount of CPU released from the Capacity related to the couple (nfviPoP, zoneId)
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT numVirtualCpu FROM virtualcpu where computeFlavourId=?");
                ps.setLong(1, computeFlavourId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    numVirtualCpu = rs.getLong("numVirtualCpu");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> numVirtualCpu: " + numVirtualCpu + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Amount of Memory released from the Capacity related to the couple (nfviPoP, zoneId)
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT virtualMemSize FROM `mtpdomdb`.`virtualmemorydata` where computeFlavourId=?");
                ps.setLong(1, computeFlavourId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    memorySize = rs.getLong("virtualMemSize");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> virtualMemSize: " + memorySize + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Amount of Storage released from the Capacity related to the couple (nfviPoP, zoneId)
            try {

                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT sizeOfStorage FROM virtualstoragedata where computeFlavourId=?");
                ps.setLong(1, computeFlavourId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    storageSize = storageSize + rs.getLong("sizeOfStorage");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> sizeOfStorage: " + storageSize + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update memory capacity in Domain DB
            try {
                long availableMemCapacity;
                long allocatedMemCapacity;
                long currentAvailableMemCapacity;
                long currentAllocatedMemCapacity;
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                // INNER JOIN SELECT QUERY
                //PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity from memoryresources inner join zoneid on zoneid.NfviPopId=? where memoryresources.resourceZoneId=zoneid.resourceZoneId");
                //STANDARD SELECT QUERY
                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, resourceZoneId from memoryresources where memoryresources.resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, zoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableMemCapacity = rs.getLong("availableCapacity");
                    allocatedMemCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableMemCapacity = availableMemCapacity + memorySize;
                    currentAllocatedMemCapacity = allocatedMemCapacity - memorySize;
                    rs.updateLong("availableCapacity", availableMemCapacity + memorySize);
                    rs.updateLong("allocatedCapacity", allocatedMemCapacity - memorySize);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Memory capacity updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old available  memory capacity " + availableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current available  memory capacity " + currentAvailableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old allocated  memory capacity " + allocatedMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current allocated memory capacity " + currentAllocatedMemCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update memory capacity in Abstraction DB
            try {
                long availableMemCapacity;
                long allocatedMemCapacity;
                long currentAvailableMemCapacity;
                long currentAllocatedMemCapacity;
                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, abstrResourceZoneId from abstrmemoryresources where abstrResourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, abstrResourceZoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableMemCapacity = rs.getLong("availableCapacity");
                    allocatedMemCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableMemCapacity = availableMemCapacity + memorySize;
                    currentAllocatedMemCapacity = allocatedMemCapacity - memorySize;
                    rs.updateLong("availableCapacity", availableMemCapacity + memorySize);
                    rs.updateLong("allocatedCapacity", allocatedMemCapacity - memorySize);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Memory capacity updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old available  memory capacity " + availableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current available  memory capacity " + currentAvailableMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old allocated  memory capacity " + allocatedMemCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current allocated memory capacity " + currentAllocatedMemCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update storage capacity in Domain DB
            try {
                long availableStorageCapacity;
                long allocatedStorageCapacity;
                long currentAvailableStorageCapacity;
                long currentAllocatedStorageCapacity;
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, resourceZoneId from storageresources where resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, zoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableStorageCapacity = rs.getLong("availableCapacity");
                    allocatedStorageCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableStorageCapacity = availableStorageCapacity + storageSize;
                    currentAllocatedStorageCapacity = allocatedStorageCapacity - storageSize;
                    rs.updateLong("availableCapacity", availableStorageCapacity + storageSize);
                    rs.updateLong("allocatedCapacity", allocatedStorageCapacity - storageSize);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Memory capacity updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old available storage capacity " + availableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current available storage capacity " + currentAvailableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old allocated storage capacity " + allocatedStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current allocated storage capacity " + currentAllocatedStorageCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update storage capacity in Abstraction DB
            try {
                long availableStorageCapacity;
                long allocatedStorageCapacity;
                long currentAvailableStorageCapacity;
                long currentAllocatedStorageCapacity;
                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, abstrResourceZoneId from abstrstorageresources where abstrResourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, abstrResourceZoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableStorageCapacity = rs.getLong("availableCapacity");
                    allocatedStorageCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableStorageCapacity = availableStorageCapacity + storageSize;
                    currentAllocatedStorageCapacity = allocatedStorageCapacity - storageSize;
                    rs.updateLong("availableCapacity", availableStorageCapacity + storageSize);
                    rs.updateLong("allocatedCapacity", allocatedStorageCapacity - storageSize);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Memory capacity updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old available  storage capacity " + availableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current available  storage capacity " + currentAvailableStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old allocated  storagecapacity " + allocatedStorageCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current allocated storage capacity " + currentAllocatedStorageCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update CPU capacity in Domain DB
            try {
                long availableCpuCapacity;
                long allocatedCpuCapacity;
                long currentAvailableCpuCapacity;
                long currentAllocatedCpuCapacity;
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                // INNER JOIN SELECT QUERY
                //PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity from memoryresources inner join zoneid on zoneid.NfviPopId=? where memoryresources.resourceZoneId=zoneid.resourceZoneId");
                //STANDARD SELECT QUERY
                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, resourceZoneId from cpuresources where resourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, zoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableCpuCapacity = rs.getLong("availableCapacity");
                    allocatedCpuCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableCpuCapacity = availableCpuCapacity + numVirtualCpu;
                    currentAllocatedCpuCapacity = allocatedCpuCapacity - numVirtualCpu;
                    rs.updateLong("availableCapacity", availableCpuCapacity + numVirtualCpu);
                    rs.updateLong("allocatedCapacity", allocatedCpuCapacity - numVirtualCpu);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> CPU capacity updated in DOMAIN_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old available cpu capacity " + availableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current available cpu capacity " + currentAvailableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old allocated cpu capacity " + allocatedCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current allocated cpu capacity " + currentAllocatedCpuCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Update CPU capacity in Abstraction DB
            try {
                long availableCpuCapacity;
                long allocatedCpuCapacity;
                long currentAvailableCpuCapacity;
                long currentAllocatedCpuCapacity;
                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("select availableCapacity,reservedCapacity,totalCapacity, allocatedCapacity, abstrResourceZoneId from abstrcpuresources where abstrResourceZoneId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, abstrResourceZoneId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableCpuCapacity = rs.getLong("availableCapacity");
                    allocatedCpuCapacity = rs.getLong("allocatedCapacity");
                    currentAvailableCpuCapacity = availableCpuCapacity + numVirtualCpu;
                    currentAllocatedCpuCapacity = allocatedCpuCapacity - numVirtualCpu;
                    rs.updateLong("availableCapacity", availableCpuCapacity + numVirtualCpu);
                    rs.updateLong("allocatedCapacity", allocatedCpuCapacity - numVirtualCpu);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Memory capacity updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old available cpu capacity " + availableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current available cpu capacity " + currentAvailableCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Old allocated cpu capacity " + allocatedCpuCapacity + "");
                    System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Current allocated cpu capacity " + currentAllocatedCpuCapacity + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
//

            //Remove entry from VirtualCPU //
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualcpu WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Entry removed from VirtualCPU table for ComputeServiceId:" + computeServiceId + "");
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from VirtualMemory
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualmemory WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Entry removed from VirtualMemory table for ComputeServiceId:" + computeServiceId + "");
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from VirtualNetworkInterface
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualnetworkinterface WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Entry removed from VirtualNetworkInterface table for ComputeServiceId:" + computeServiceId + "");
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from VirtualCompute
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualcompute WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                System.out.println("DatabaseDriver.handle_ComputeTerminateDBQuery ---> Entry removed from VirtualCompute table for ComputeServiceId:" + computeServiceId + "");
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from VirtualInterfaceData
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualinterfacedata WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from UserData
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM userdata WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from AffinityOrAntiafffinityConstraint
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM affinityorantiaffinityconstraint WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
            //Remove entry from ComputeServiceRequestData

            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM computeservicerequestdata WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove entry from ComputeServices
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM computeservices WHERE computeServiceId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setLong(1, computeServiceId);
                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }

        E2EComputeTerminateInstanceOutcome allinstout = new E2EComputeTerminateInstanceOutcome(dboutcome.getReqid(),
                dboutcome.getServid(), dboutcome.getComputeIdList());
        System.out.println("ResouceOrchestration --> Post E2EComputeTerminateInstanceOutcome Event");

        SingletonEventBus.getBus().post(allinstout);

    }

    @Subscribe
    public void handle_NetworkTerminateDBQuery(NetworkTerminateDBQuery dbquery) {
        System.out.println("DatabaseDriver ---> Handle NetworkTerminateDBQuery Event");

        //START - Retrieve from DB the list of wanLinks, interDomainLinks and intraPopLinks related to the
        // logicalPathId to terminate
        List<String> netServIdList = dbquery.getNetServIdList();
        List<String> logicalPathIdList = new ArrayList();
        HashMap<Integer, ArrayList<Long>> interdomainLinksMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> intraPopLinksMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> wanLinksMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> wimPopListMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> vimPopListMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> wimdomlistMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> vimdomlistMap = new HashMap();
        HashMap<Integer, ArrayList<String>> vimNetworkTypeMap = new HashMap();
        HashMap<Integer, ArrayList<String>> wimNetworkTypeMap = new HashMap();
        HashMap<Integer, ArrayList<Long>> wanResourceIdListMap = new HashMap();

        //Retrieve from DB the locicalPaths related to the netServIds
        for (int i = 0; i < dbquery.getNetServIdList().size(); i++) {
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT logicalPathId FROM networkservices where netServId=?");
                ps.setString(1, dbquery.getNetServIdList().get(i));
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    // System.out.println("Test: " + rs.getInt("logicalPathId") + "");
                    logicalPathIdList.add(String.valueOf(rs.getInt("logicalPathId")));
                    System.out.println("handle_NetworkTerminateDBQuery ---> logicalPathId: " + rs.getInt("logicalPathId") + "");

                }
                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

        }

        //START - Loop on logicalPaths
        for (int i = 0; i < logicalPathIdList.size(); i++) {
            ArrayList<Long> interdomainLinks = new ArrayList();
            ArrayList<Long> intraPopLinks = new ArrayList();
            ArrayList<Long> wanLinks = new ArrayList();
            ArrayList<Long> wimPopList = new ArrayList();
            ArrayList<Long> vimPopList = new ArrayList();
            ArrayList<Long> wimdomlist = new ArrayList();
            ArrayList<Long> vimdomlist = new ArrayList();
            ArrayList<String> vimNetworkType = new ArrayList();
            ArrayList<String> wimNetworkType = new ArrayList();
            ArrayList<Long> wanResourceIdList = new ArrayList();

            String logicalPathId = logicalPathIdList.get(i);
            ArrayList<Integer> wimResourceIndex = new ArrayList();

            ////Get from DB the intraPopLinks, wanLinks, wimPopList, vimPopList, vimNetworkType and wimNetworkType related to the LogicalLinkId to terminate
            try {
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT interDomainLinkId FROM logicalpath_interdomainlink where logicalPathId=?");
                ps.setString(1, logicalPathId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    interdomainLinks.add(Long.valueOf(rs.getInt("interDomainLinkId")));

                    System.out.println("handle_NetworkAllocateDBQuery ---> InterDomainLinkId: " + rs.getInt("InterDomainLinkId") + "");

                }
                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Get from DB the intraPopLinks, wanLinks, wimPopList, vimPopList and networkType
            try {
                java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT logicalpath_networkresources.networkResId, logicalpath_networkresources.logicalPathId, networkresources.networkType, zoneid.nfviPopId, domain.type, domain.domId from logicalpath_networkresources \n"
                        + "INNER JOIN networkresources ON networkresources.networkResId=logicalpath_networkresources.networkResId\n"
                        + " INNER JOIN zoneid ON  networkresources.resourceZoneId=zoneid.resourceZoneId \n"
                        + "INNER JOIN nfvipop ON zoneid.nfviPopId = nfvipop.nfviPopId\n"
                        + "INNER JOIN domain ON nfvipop.domId = domain.domId\n"
                        + "where logicalpath_networkresources.logicalPathId=?");

                ps.setString(1, logicalPathId);
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    String type = rs.getString("type");
//                    if (type.equals("VIM")) {
//                        intraPopLinks.add(rs.getLong("networkResId"));
//                        vimPopList.add(rs.getLong("nfviPopId"));
//                        vimdomlist.add(rs.getLong("domId"));
//                        vimNetworkType.add(rs.getString("networkType"));
//                        System.out.println("handle_NetworkAllocateDBQuery ---> IntraPopLink - NetworkResId: " + rs.getLong("NetworkResId") + "");
//                    }

                    if (type.equals("T-WIM")) {
                        wanLinks.add(rs.getLong("networkResId"));
                        wimPopList.add(rs.getLong("nfviPopId"));
                        wimdomlist.add(rs.getLong("domId"));
                        wimNetworkType.add(rs.getString("networkType"));
                        System.out.println("handle_NetworkAllocateDBQuery ---> WanLink - NetworkResId: " + rs.getLong("NetworkResId") + "");

                    }

                }
                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Get from DB the networkResourceId of WAN resources
            for (int j = 0; j < wanLinks.size(); j++) {
                try {
                    java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT networkResourceId FROM virtualnetwork where netServId=? and netResIdRef=?");
                    ps.setString(1, dbquery.getNetServIdList().get(i));
                    ps.setLong(2, wanLinks.get(j));
                    java.sql.ResultSet rs = ps.executeQuery();
                    while (rs.next()) {

                        wanResourceIdList.add(rs.getLong("networkResourceId"));

                    }
                    rs.close();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            //Get from DB the intraPopLinks, vimPopList and networkType
            //Get All Virtual Network
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT networkResourceId, networkType, nfviPopId FROM virtualnetwork where netServId=? and netResIdRef is null");
                ps.setString(1, dbquery.getNetServIdList().get(i));

                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    intraPopLinks.add(rs.getLong("networkResourceId"));
                    vimPopList.add(rs.getLong("nfviPopId"));
                    vimNetworkType.add(rs.getString("networkType"));

                }
                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

//            //Get from DB the vimdomlist related to the vimPopList
            for (int j = 0; j < vimPopList.size(); j++) {

                try {
                    java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT nfvipop.domId, domain.type "
                            + "FROM nfvipop "
                            + "INNER JOIN domain ON domain.domId=nfvipop.domId "
                            + "where nfviPopId=?");
                    ps.setLong(1, vimPopList.get(j));
                    java.sql.ResultSet rs = ps.executeQuery();
                    while (rs.next()) {

                        if (rs.getString("type").equals("VIM")) {

                            vimdomlist.add(rs.getLong("domId"));
                        }
                    }
                    rs.close();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            interdomainLinksMap.put(i, interdomainLinks);
            intraPopLinksMap.put(i, intraPopLinks);
            wanLinksMap.put(i, wanLinks);
            wimPopListMap.put(i, wimPopList);
            vimPopListMap.put(i, vimPopList);
            wimdomlistMap.put(i, wimdomlist);
            vimdomlistMap.put(i, vimdomlist);
            vimNetworkTypeMap.put(i, vimNetworkType);
            wimNetworkTypeMap.put(i, wimNetworkType);
            wanResourceIdListMap.put(i, wanResourceIdList);

        }
        //END - Loop on logicalPaths

//        NetworkTerminateDBQueryReply dbreply = new NetworkTerminateDBQueryReply(dbquery.getReqId(), dbquery.getServId());        
        NetworkTerminateDBQueryReply dbreply = new NetworkTerminateDBQueryReply(dbquery.getReqid(), dbquery.getServid(),
                wimdomlistMap, vimdomlistMap, interdomainLinksMap, intraPopLinksMap, wanLinksMap, wimPopListMap, vimPopListMap,
                wimNetworkTypeMap, vimNetworkTypeMap, wanResourceIdListMap, netServIdList, logicalPathIdList);

        System.out.println("DatabaseDriver ---> Post NetworkTerminateDBQueryReply Event");
        SingletonEventBus.getBus().post(dbreply);

    }

    @Subscribe
    public void handle_NetworkTerminateDBQueryOutcome(NetworkTerminateDBQueryOutcome dboutcome) {
        System.out.println("DatabaseDriver ---> Handle NetworkTerminateDBQueryOutcome Event");
        //TODO update DB using JDBC raising exception if somethiong is wrong

        //Loop on logicalPaths 
        for (int i = 0; i < dboutcome.getLogicalPathList().size(); i++) {
            String netServId = null;
            long bandwidth = 0;
            List<Long> virtualnetworkIdList = new ArrayList();

            netServId = dboutcome.getNetServIdList().get(i);

            // Retrieve from DB all virtualnetworkId related to the logicalPathId
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("SELECT virtualNetworkId FROM virtualnetwork WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    System.out.println("DatabaseDriver ---> Handle NetworkTerminateDBQueryOutcome Event - VirtualNetworkId:" + rs.getLong("virtualNetworkId") + "");

                    virtualnetworkIdList.add(rs.getLong("virtualNetworkId"));
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Amount of Bandwidth released from the Capacity
            try {

                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("SELECT bandwidth FROM virtualnetworkdata WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    bandwidth = rs.getLong("bandwidth");

                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove records from Network_QoS table
            for (int j = 0; j < virtualnetworkIdList.size(); j++) {

                try {
                    java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("DELETE FROM supportednetworkqos WHERE virtualNetworkId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setLong(1, virtualnetworkIdList.get(j));

                    ps.executeUpdate();

                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            //Remove records from VIRTUAL_NETWORK_PORT table
            for (int j = 0; j < virtualnetworkIdList.size(); j++) {

                try {
                    java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualnetworkport WHERE virtualNetworkId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setLong(1, virtualnetworkIdList.get(j));

                    ps.executeUpdate();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            //Remove records from NETWORK_SUBSET table
            for (int j = 0; j < virtualnetworkIdList.size(); j++) {

                try {
                    java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("DELETE FROM networksubnet WHERE virtualNetworkId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setLong(1, virtualnetworkIdList.get(j));

                    ps.executeUpdate();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            //Remove records from VirtualNetwork table
            for (int j = 0; j < virtualnetworkIdList.size(); j++) {

                try {
                    java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualnetwork WHERE virtualNetworkId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setLong(1, virtualnetworkIdList.get(j));
                    ps.executeUpdate();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

            //Remove records from NetQoS table
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM networkqos WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

//Remove records from Layer3ConnectivityInformation table
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM layer3connectivityinformation WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove records from VirtualNetworkData table 
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualnetworkdata WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
            //Remove records from VirtualNetworkPortData table
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM virtualnetworkportdata WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove records from NetworkSubnetData table
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM networksubnetdata WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            //Remove records from networkservicerequestdata table
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM networkservicerequestdata WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

// Remove record from networkservices table
            try {
                java.sql.Connection conn = DbServiceDatasource.getInstance().getConnection();

                PreparedStatement ps = conn.prepareStatement("DELETE FROM networkservices WHERE netServId=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, netServId);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

            /**
             * ****************************************************************************************
             */
            // UNCOMMENT WHEN IFA005 API bugs are fixed
           // bandwidth = 5000000;
            /**
             * ***************************************************************************************
             */

//Update Capacity in Abstraction DB
            try {
                long availableBandwidth;
                long allocatedBandwidth;
                long currentAvailableBandwidth;
                long currentAllocatedBandwidth;

                java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();

                //STANDARD SELECT QUERY
                PreparedStatement ps = conn.prepareStatement("SELECT logicalPathId, availableBandwidth, reservedBandwidth,"
                        + " totalBandwidth, allocatedBandwidth\n"
                        + "FROM logicalpath WHERE logicalPathId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, dboutcome.getLogicalPathList().get(i));
                java.sql.ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    availableBandwidth = rs.getLong("availableBandwidth");
                    allocatedBandwidth = rs.getLong("allocatedBandwidth");
                    currentAvailableBandwidth = availableBandwidth + bandwidth;
                    currentAllocatedBandwidth = allocatedBandwidth - bandwidth;
                    rs.updateLong("availableBandwidth", currentAvailableBandwidth);
                    rs.updateLong("allocatedBandwidth", currentAllocatedBandwidth);
                    rs.updateRow();

                    System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Bandwidth updated in Abstraction_DB!");
                    System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
                    System.out.println("DatabaseDriver.handle__NetworkTerminateBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
                }

                rs.close();
                ps.close();

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseDriver.class
                        .getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }

//Update Capacity in Domain DB 
            //Update InterDomainLink capacity
            System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Update capacity in InterDomainLink table!");
            for (int j = 0; j < dboutcome.getInterdomainLinksMap().get(i).size(); j++) {

                try {
                    long availableBandwidth;
                    long allocatedBandwidth;
                    long currentAvailableBandwidth;
                    long currentAllocatedBandwidth;

                    java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("SELECT interDomainLinkId, availableBandwidth, reservedBandwidth,"
                            + " totalBandwidth, allocatedBandwidth\n"
                            + "FROM interdomainlink WHERE interDomainLinkId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setLong(1, dboutcome.getInterdomainLinksMap().get(i).get(j));
                    java.sql.ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        availableBandwidth = rs.getLong("availableBandwidth");
                        allocatedBandwidth = rs.getLong("allocatedBandwidth");
                        currentAvailableBandwidth = availableBandwidth + bandwidth;
                        currentAllocatedBandwidth = allocatedBandwidth - bandwidth;
                        rs.updateLong("availableBandwidth", currentAvailableBandwidth);
                        rs.updateLong("allocatedBandwidth", currentAllocatedBandwidth);
                        rs.updateRow();

                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Bandwidth updated in Abstraction_DB!");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
                    }

                    rs.close();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

//            //Update IntraPopLinks capacity
//            System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Update capacity in NETWORKRESOURCES table!");
//            for (int j = 0; j < dboutcome.getIntraPopLinksMap().get(i).size(); j++) {
//
//                try {
//                    long availableBandwidth;
//                    long allocatedBandwidth;
//                    long currentAvailableBandwidth;
//                    long currentAllocatedBandwidth;
//
//                    java.sql.Connection conn = DbAbstractionDatasource.getInstance().getConnection();
//
//                    PreparedStatement ps = conn.prepareStatement("SELECT networkResId, availableCapacity, reservedCapacity,"
//                            + " totalCapacity, allocatedCapacity\n"
//                            + "FROM networkresources WHERE networkResId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//                    ps.setLong(1, dboutcome.getIntraPopLinksMap().get(i).get(j));
//                    java.sql.ResultSet rs = ps.executeQuery();
//                    while (rs.next()) {
//                        availableBandwidth = rs.getLong("availableCapacity");
//                        allocatedBandwidth = rs.getLong("allocatedCapacity");
//                        currentAvailableBandwidth = availableBandwidth + bandwidth;
//                        currentAllocatedBandwidth = allocatedBandwidth - bandwidth;
//                        rs.updateLong("availableCapacity", currentAvailableBandwidth);
//                        rs.updateLong("allocatedCapacity", currentAllocatedBandwidth);
//                        rs.updateRow();
//
//                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Bandwidth updated in Abstraction_DB!");
//                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
//                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
//                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
//                        System.out.println("DatabaseDriver.handle__NetworkTerminateBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
//                    }
//
//                    rs.close();
//                    ps.close();
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(DatabaseDriver.class
//                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
//                }
//
//            }
            //Update WanLinks capacity
            System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Update capacity in NETWORKRESOURCES table!");
            for (int j = 0; j < dboutcome.getWanLinksMap().get(i).size(); j++) {

                try {
                    long availableBandwidth;
                    long allocatedBandwidth;
                    long currentAvailableBandwidth;
                    long currentAllocatedBandwidth;

                    java.sql.Connection conn = DbDomainDatasource.getInstance().getConnection();

                    PreparedStatement ps = conn.prepareStatement("SELECT networkResId, availableCapacity, reservedCapacity,"
                            + " totalCapacity, allocatedCapacity\n"
                            + "FROM networkresources WHERE networkResId=? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setLong(1, dboutcome.getWanLinksMap().get(i).get(j));
                    java.sql.ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        availableBandwidth = rs.getLong("availableCapacity");
                        allocatedBandwidth = rs.getLong("allocatedCapacity");
                        currentAvailableBandwidth = availableBandwidth + bandwidth;
                        currentAllocatedBandwidth = allocatedBandwidth - bandwidth;
                        rs.updateLong("availableCapacity", currentAvailableBandwidth);
                        rs.updateLong("allocatedCapacity", currentAllocatedBandwidth);
                        rs.updateRow();

                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Bandwidth updated in Abstraction_DB!");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old available bandwidth " + availableBandwidth + "");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Current available bandwidth" + currentAvailableBandwidth + "");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateDBQueryOutcome ---> Old allocated bandwidth " + allocatedBandwidth + "");
                        System.out.println("DatabaseDriver.handle__NetworkTerminateBQueryOutcome ---> Current allocated bandwidth " + currentAllocatedBandwidth + "");
                    }

                    rs.close();
                    ps.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseDriver.class
                            .getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }

            }

        } //END Loop on LogicalPaths

        E2ENetworkTerminateInstanceOutcome netinst = new E2ENetworkTerminateInstanceOutcome(dboutcome.getReqid(),
                dboutcome.getServid(), dboutcome.getNetServIdList(), dboutcome.getLogicalPathList());
        System.out.println("DatabaseDriver --> Post E2ENetworkTerminateInstanceOutcome Event");
        SingletonEventBus.getBus().post(netinst);

    }
}
