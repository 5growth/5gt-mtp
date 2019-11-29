/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.events.resourcemanagement.ComputeAllocation;

import com.mtp.extinterface.nbi.swagger.model.VirtualCompute;


public class E2EComputeAllocateReply {

    private long reqid;
    private String servid; //service identifiers
    private VirtualCompute computereply; //contains vim computation info 
    private boolean outcome;

    public E2EComputeAllocateReply(long reqid, String servid, VirtualCompute computereply, boolean outcome) {
        this.reqid = reqid;
        this.servid = servid;
        this.computereply = computereply;
        this.outcome = outcome;
    }

    //insert set/get methods
    public long getReqid() {
        return reqid;
    }

    public void setReqid(long reqid) {
        this.reqid = reqid;
    }

    public String getServid() {
        return servid;
    }

    public void setServid(String servid) {
        this.servid = servid;
    }

    public VirtualCompute getComputereply() {
        return computereply;
    }

    public void setComputereply(VirtualCompute computereply) {
        this.computereply = computereply;
    }



    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

}
