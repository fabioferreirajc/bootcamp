package org.academiadecodigo.stormrooters.inetadress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Inet {
    private InetAddress local;
    private InetAddress host;


    public void local() {
        try {
            local = InetAddress.getLocalHost();
            System.out.println("My IP  " + local);

        } catch (UnknownHostException uhe) {
            uhe.getMessage();
        }

    }


    public void getIpAndTest(String site,int timeout) {

        try {
            host = InetAddress.getByName(site);
            System.out.println("IP " + host);

        } catch (UnknownHostException uhe) {
            uhe.getMessage();
        }

        try {
            System.out.println(host.isReachable(timeout));

        } catch (IOException io) {
            io.getMessage();
        }
    }


}
