/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.extinterface.sbi.StubThreads;

import com.mtp.SingletonEventBus;
import com.mtp.common.objects.DomainElem;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateVIMReply;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateVIMReq;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateWIMReply;
import com.mtp.events.resourcemanagement.NetworkTermination.NetworkTerminateWIMReq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author efabuba
 */
public class TerminateWIMNetworkStub extends Thread {

    private HashMap<Integer, List<DomainElem>> dominfoMap;
    private NetworkTerminateWIMReq request;

    public TerminateWIMNetworkStub(HashMap<Integer, List<DomainElem>> val, NetworkTerminateWIMReq req) {
        dominfoMap = val;
        request = req;
    }

    @Override
    public void run() {

        NetworkTerminateWIMReply termwimrep;

        HashMap<Integer, ArrayList<Boolean>> outcomeListMap = new HashMap();
        HashMap<Integer, ArrayList<Integer>> errorcodeListMap = new HashMap();
        HashMap<Integer, ArrayList<String>> errormsgListMap = new HashMap();
        ArrayList<Boolean> outcomeList = new ArrayList();
        ArrayList<Integer> errorcodeList = new ArrayList();
        ArrayList<String> errormsgList = new ArrayList();

        //Loop on logicaLinks
        for (int j = 0; j < dominfoMap.size(); j++) {
            //Loop on domIds
            for (int i = 0; i < dominfoMap.get(j).size(); i++) {

                outcomeList.add(Boolean.TRUE);

                //Identifier of resource to terminate in the domain 
                System.out.println("TerminateWIMNetworkStub --> ResourceId to terminate:" + request.getWanResourceIdListMap().get(j).get(i) + "");

                
            }//END loop on domIds

            outcomeListMap.put(j, outcomeList);
            errorcodeListMap.put(j, errorcodeList);
            errormsgListMap.put(j, errormsgList);
        }//END lopp on  logicaLinks

        //send event will all message OK
        termwimrep = new NetworkTerminateWIMReply(request.getReqid(), request.getServid(),
                outcomeListMap, errorcodeListMap, errormsgListMap);
        SingletonEventBus.getBus().post(termwimrep);
    }
}
