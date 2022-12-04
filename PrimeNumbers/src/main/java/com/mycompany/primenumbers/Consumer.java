package com.mycompany.primenumbers;

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
        	FileWriter fileWriter = new FileWriter(fileName, true);
            while (true) {
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
                    if(prime == 2){
                        fileWriter.write("\"" + prime + "\"");
                    }else{
                        fileWriter.write(" , \"" + prime + "\"");
                    }
                    queue.notifyAll();
                }  
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}