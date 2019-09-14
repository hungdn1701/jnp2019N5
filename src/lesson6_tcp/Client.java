/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class Client {
    public static void main(String[] args) {
        String str = "hungdn",str2="ptit.edu.vn";
        try {
            Socket client = new Socket("localhost", 1107);
            BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream(),4096);
            System.out.println(str.length());
            out.write(str.getBytes());
            out.flush();
            out.write(str2.getBytes());
            out.flush();
            out.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
