/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11_wsClient;

/**
 *
 * @author mam
 */
public class CalculatorClient {
    public static void main(String[] args) {
        medianews.vn.Calculator_Service service = new medianews.vn.Calculator_Service();
        medianews.vn.Calculator port = service.getCalculatorPort();
        System.out.println(port.add(200, 100));
    }

   
}
