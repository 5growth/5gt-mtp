/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.events.abstraction.Creation;

import java.util.ArrayList;
import com.mtp.common.objects.*;
import com.mtp.extinterface.nbi.swagger.model.NfviPop;
import com.mtp.extinterface.nbi.swagger.model.ResourceZone;
import java.util.List;

/**
 *
 * @author user
 */
public class WIMResAbstractionEvent {
    private long id; //id of the VIM domain
    List<NfviPop> poplist;
    List<ResourceZone> zonelist;
    List<NetworkResElem> netinfolist;
    List <MapResources> netresmap;
    
    public WIMResAbstractionEvent() {
        id = 0;
        poplist = new ArrayList();
        zonelist = new ArrayList();
        netinfolist = new ArrayList();
        netresmap = new ArrayList();
    }
    public WIMResAbstractionEvent(long idval) {
        id = idval;
        poplist = new ArrayList();
        zonelist = new ArrayList();
        netinfolist = new ArrayList();
        netresmap = new ArrayList();
    }
    //get/set function
    public long getId() {
        return id;
    } 
    public void setId(long val) {
        id = val;
    }
    public List<NfviPop> getPopList() {
        return poplist;
    }
    public void setPopList(List<NfviPop> plist) {
        poplist = plist;
    }
    public NfviPop getPopElem(int i) {
        if (poplist.isEmpty()) 
            return new NfviPop();
        return poplist.get(i);
    }
    public void setPopElem(NfviPop domelem) {
        poplist.add(domelem);
    }
    public List<ResourceZone> getZoneList() {
        return zonelist;
    }
    public void setZoneList(List<ResourceZone> plist) {
        zonelist = plist;
    }
    public ResourceZone getZoneElem(int i) {
        if (zonelist.isEmpty()) 
            return new ResourceZone();
        return zonelist.get(i);
    }
    public void setZoneElem(ResourceZone domelem) {
        zonelist.add(domelem);
    }
    public List<NetworkResElem> getNetworkResList() {
        return netinfolist;
    }
    public void setNetworkResList(List<NetworkResElem> plist) {
        netinfolist = plist;
    }
    public NetworkResElem getNetworkResElem(int i) {
        if (netinfolist.isEmpty()) 
            return new NetworkResElem();
        return netinfolist.get(i);
    }
    public void setNetworkResElem(NetworkResElem domelem) {
        netinfolist.add(domelem);
    }
    public List<MapResources> getNetworkMapList() {
        return netresmap;
    }
    public void setNetworkMapList(List<MapResources> plist) {
        netresmap = plist;
    }
    public MapResources getNetworkMapElem(int i) {
        if (netresmap.isEmpty()) 
            return null;
        return netresmap.get(i);
    }
    public void setNetworkMapElem(MapResources domelem) {
        netresmap.add(domelem);
    }
}