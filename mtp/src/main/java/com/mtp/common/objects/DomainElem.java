/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtp.common.objects;

import java.net.InetAddress;
import java.net.UnknownHostException;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Lenovo
 */
public class DomainElem {
    //XXX: Need a http port
    private String ip; //ip to use for connect to server WIM/VIM
    private long port; //port to use for connect to server WIM/VIM
    private String name;
    private String type;  //1 WIM-Transport, 2 WIM radio, 3 VIM, 4 MEC, ....
    private long id; // id of domain
    
    public DomainElem() {
        type = "";
        name = "";
        ip = "127.0.0.1";
        port = -1;
        id = -1;
    };
    public DomainElem(String typeval, String nameval, String ipval, long portval, long idval) {
        type = typeval;
        name = nameval;
        ip = ipval;
        port = portval;
        id = idval;
    }
    //get/set function
    public String getIp() {
        return ip;
    }
    public void setIp(String val) {
        ip = val;
    }
    public String getName() {
        return name;
    }
    public void setName(String val) {
        name = val;
    }
    public String getType() {
        return type;
    } 
    public void setType(String val) {
        type = val;
    }
    public long getPort() {
        return port;
    } 
    public void setPort(long val) {
        port = val;
    }
    public long getId() {
        return id;
    } 
    public void setId(long val) {
        id = val;
    }
}