/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.events.resourcemanagement.NetworkAllocation;

import com.mtp.extinterface.nbi.swagger.model.VirtualNetwork;

public class E2ENetworkAllocateReply {

    private long reqid;
    private long servid; //service identifiers
    private VirtualNetwork vn;
    private boolean outcome;

    public E2ENetworkAllocateReply(long reqid, long servid, VirtualNetwork vn, boolean outcome) {
        this.reqid = reqid;
        this.servid = servid;
        this.vn = vn;
        this.outcome = outcome;
    }

    //insert set/get methods
    public long getReqid() {
        return reqid;
    }

    public void setReqid(long reqid) {
        this.reqid = reqid;
    }

    public long getServid() {
        return servid;
    }

    public void setServid(long servid) {
        this.servid = servid;
    }

    public VirtualNetwork getVn() {
        return vn;
    }

    public void setVn(VirtualNetwork vn) {
        this.vn = vn;
    }

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

}