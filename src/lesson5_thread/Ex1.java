/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5_thread;

/**
 *
 * @author mam
 */
public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintNameThread("A")).start();
        new Thread(new PrintNameThread("B")).start();
        new Thread(new PrintNameThread("C")).start();
        new Thread(new PrintNameThread("D")).start();
    }
}
class PrintNameThread implements Runnable{
    String _name;

    public PrintNameThread(String _name) {
        this._name = _name;
    }
    
    
    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            System.out.println(this._name);
    }
    
}


