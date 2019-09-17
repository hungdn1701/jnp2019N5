/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

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
public class UDPClient {
    DatagramSocket client;
    DatagramPacket sendPacket, receivePacket;
    byte[] sendBuff, receiveBuff;
    int buffSize;
    public UDPClient() {
        try {
            buffSize = 1024;
            client = new DatagramSocket();
            
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String str){

        try {
            // gửi
            sendBuff = str.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            sendPacket = new DatagramPacket(sendBuff,sendBuff.length,address, 1107);
            client.send(sendPacket);

            
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void receive() {
        try {
            // nhận
            receiveBuff = new byte[buffSize];
            receivePacket = new DatagramPacket(receiveBuff, buffSize);

            client.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()).trim());
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
}
