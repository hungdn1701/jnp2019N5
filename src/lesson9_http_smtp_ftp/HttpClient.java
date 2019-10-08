/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson9_http_smtp_ftp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class HttpClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("ptit.edu.vn", 80);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            String str = "GET / HTTP/1.1\r\n"
                    + "Host: localhost:8080\r\n"
                    + "User-Agent: Mozilla/5.0 hungdn/1.0\r\n"
                    + "Connection: keep-alive\r\n"
                    + "Accept: text/html\r\n";
//            String str = "hello ptit.edu.vn";
            out.write(str);
            out.newLine();
            out.flush();
            
            InputStream in = client.getInputStream();
            byte[] data = new byte[4096];
            in.read(data);
            System.out.println(new String(data).trim());
            
            out.close();
            client.close();
            
        } catch (IOException ex) {
            Logger.getLogger(HttpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
