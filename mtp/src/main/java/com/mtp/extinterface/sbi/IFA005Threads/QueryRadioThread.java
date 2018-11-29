/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.extinterface.sbi.IFA005Threads;

import com.mtp.SingletonEventBus;
import com.mtp.common.objects.DomainElem;
import com.mtp.events.abstraction.Creation.RadioResAbstractionEvent;

/**
 *
 * @author efabuba
 */
public class QueryRadioThread extends Thread {
    private DomainElem dominfo;
    public QueryRadioThread (DomainElem val) {
        dominfo = val;
    }
    
    @Override
    public void run() {
        //TODO: perform query list for Radio domain
        
        
        RadioResAbstractionEvent ev = new RadioResAbstractionEvent(dominfo.getId());
        //TODO: prepare event to collect info
        //send event
        SingletonEventBus.getBus().post(ev);
    }    
}
