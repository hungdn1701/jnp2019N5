/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8_nic_multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class MClient {
    public static void main(String[] args) {
        try {
            MulticastSocket client = new MulticastSocket(1107);
            InetAddress mcastaddr = InetAddress.getByName("224.2.2.3");
            client.joinGroup(mcastaddr);
            while(true){
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                client.receive(packet);
                System.out.println(new String(packet.getData()).trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(MClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
