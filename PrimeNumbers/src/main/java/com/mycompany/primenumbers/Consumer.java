/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primenumbers;

/**
 *
 * @author misho
 */
import java.io.FileWriter;
import java.util.Queue;

public class Consumer extends Thread {
    Queue<Integer> queue;
    String fileName;
    int counter = 0;
    int greatest = 0;

    public Consumer(Queue<Integer> queue, String fileName, int size) {
        this.queue = queue;
        this.fileName = fileName;
    }

    public void run() {
        try {
            while (true) {
                FileWriter fileWriter = new FileWriter(fileName, true);
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    int prime = queue.remove();
                    if (prime == -1) {
                        break;
                    }
                    counter++;
                    greatest = prime;
                    if(prime == 0){
                        fileWriter.write("\"" + prime + "\"");
                    }else{
                        fileWriter.write(" , \"" + prime + "\"");
                    }
                    queue.notifyAll();
                }
                fileWriter.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}