/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.events.federation.Advertisement;

import com.mtp.extinterface.nbi.swagger.model.Fed_InlineResponse2003;

/**
 *
 * @author ezimbgi
 */
public class AdvertiseE2EFederationReply {
       private long reqid;
    private Fed_InlineResponse2003 response;

    
    
    
    
    public AdvertiseE2EFederationReply(long reqid, Fed_InlineResponse2003 response) {
        this.reqid = reqid;
        this.response = response;
    }

    
    
    
    
    public long getReqid() {
        return reqid;
    }

    public void setReqid(long reqid) {
        this.reqid = reqid;
    }

    public Fed_InlineResponse2003 getResponse() {
        return response;
    }

    public void setResponse(Fed_InlineResponse2003 response) {
        this.response = response;
    }
    
    
    
    
    
    
}
