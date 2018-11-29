/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.xenplugin.events.terminate;



import java.util.List;
/**
 *
 * @author Lenovo
 */
public class ComputeTerminateReply {
    private long reqid;
    private List<String> e2ewimelem; //contains vim computation info 
    /*
     * TODO: Create object for allocation request of virtual resources according 
     * IFA005
     */
    
    public ComputeTerminateReply() {
        reqid = 0;

        e2ewimelem = null;
    }

    public ComputeTerminateReply(long id, List<String> elem) {
        reqid = id;
        e2ewimelem = elem;
    }
    
    //insert set/get methods
    public long getReqId() {
        return reqid;
    }
    public void setReqId( long reqval) {
        reqid = reqval;
    }
    public List<String> getReply() {
        return e2ewimelem;
    }
    public void setReply(List<String> wimelem) {
        e2ewimelem = wimelem;
    }

}
