/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class UDPServer {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    String receiveStr ="", sendStr="";
    byte[] receiceBuff, sendBuff;
    int buffSize;
    public UDPServer() {
        try {
            buffSize = 1024;
            server = new DatagramSocket(1107);
            System.out.println("server opened ...");
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listening(){
        System.out.println("listening ...");
        while(true){
            try {
                // Nhận gói tin
                receiceBuff = new byte[buffSize];
                receivePacket = new DatagramPacket(receiceBuff, receiceBuff.length);
                server.receive(receivePacket);
                
                receiveStr = new String(receivePacket.getData());
                System.out.println(receiveStr.trim());
                
                // Gửi gói tin chứa chuỗi đảo ngược
                sendStr = StrUtil.reverse(receiveStr);
                sendBuff = sendStr.getBytes();
                
                sendPacket = new DatagramPacket(sendBuff,sendBuff.length
                        ,receivePacket.getSocketAddress());
                        
                server.send(sendPacket);
                System.out.println("done!");
                
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
