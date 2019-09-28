/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8_nic_multicast;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class NICList {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = 
                    NetworkInterface.getNetworkInterfaces();
            while(networkInterfaces.hasMoreElements()){
                NetworkInterface ni = networkInterfaces.nextElement();
                if(ni.isUp())
                {
                    System.out.println(ni);
                    Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                    while(inetAddresses.hasMoreElements())
                    {
                        System.out.println("   - " + inetAddresses.nextElement());
                    }
                    
                    
                    
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(NICList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
