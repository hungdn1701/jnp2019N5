/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson10_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class CalculatorServer {
    public static void main(String[] args) {
        
        try {
            CalculatorImpl cal = new CalculatorImpl();
            Naming.rebind("rmi://localhost/cal", cal);
        } catch (RemoteException ex) {
            Logger.getLogger(CalculatorServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CalculatorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
