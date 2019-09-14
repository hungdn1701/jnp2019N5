/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author mam
 */
public class Client800 {
    public static void main(String[] args) {

        try (Socket client = new Socket("localhost", 1107);
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream())) {
            out.writeUTF("B16DCCN111;800");
            int a = in.readInt();
            int b = in.readInt();
            // client
            out.writeInt(a+b);
            out.writeInt(a*b);
 
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
