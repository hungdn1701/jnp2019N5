/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author mam
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1107);
            System.out.println("server staterd.");
            while(true){
                Socket conn = server.accept();
                System.out.format("a client connected {%s,port: %d remote port: %d}\n"
                        ,conn.getInetAddress().getHostName(), conn.getLocalPort(), conn.getPort());
                BufferedInputStream in = new BufferedInputStream(conn.getInputStream(),1000);
                byte[] b = new byte[100];
                byte[] a = new byte[100];
                in.read(a);
                in.read(b);
                System.out.println(new String(a).toUpperCase());
                System.out.println(new String(b).toUpperCase());
                conn.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
