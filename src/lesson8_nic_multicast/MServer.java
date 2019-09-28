/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8_nic_multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class MServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket();
            for(int i = 0; i < 1000; i++)
            {
                byte[] data = ("message " + i).getBytes();
                InetAddress address = InetAddress.getByName("224.2.2.3");
                DatagramPacket dp = 
                        new DatagramPacket(data, data.length,address, 1107);
                server.send(dp);
                Thread.sleep(5000);
            }
        } catch (SocketException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
