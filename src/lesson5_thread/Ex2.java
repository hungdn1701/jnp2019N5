/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5_thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class Ex2 {
    public static void main(String[] args) throws InterruptedException {
        SharedData sharedData = new SharedData();
        
        new Consumer(sharedData).start();
        new Producer(sharedData).start();
//        Thread.sleep(5000);
        new Consumer(sharedData).start();
       
    }
}

class SharedData {
    int data;
    boolean produced = false;
    public synchronized void produce(int data) 
    {
        if(produced)
        {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SharedData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.data = data;
        System.out.println("produce: " + data);
        produced = true;
        notify();
    }
    
    public synchronized void consume() 
    {
        if(!produced){
        try {
            this.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedData.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        System.out.println("cosume: " + this.data);
        produced = false;
        this.data = 0;
        notify();
    }
}

class Producer extends Thread{
    SharedData shareData;

    public Producer(SharedData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            shareData.produce((int)(Math.random()*100));
    }
       
}

class Consumer extends Thread{
    SharedData sharedData;

    public Consumer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            sharedData.consume();
    }
    
}
