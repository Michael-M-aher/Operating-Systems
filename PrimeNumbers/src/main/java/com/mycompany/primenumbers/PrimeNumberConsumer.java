package com.mycompany.primenumbers;

import java.io.FileWriter;
import java.util.Queue;

public class PrimeNumberConsumer extends Thread {
    Queue<Integer> queue;
    String fileName;
    int counter = 0;
    int greatest = 0;

    public PrimeNumberConsumer(Queue<Integer> queue, String fileName, int size) {
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
                    int primeNumber = queue.remove();
                    if (primeNumber == -1) {
                        break;
                    }
                    counter++;
                    greatest = primeNumber;
                    if (primeNumber == 2) {
                        fileWriter.write("\"" + primeNumber + "\"");
                    } else {
                        fileWriter.write(" , \"" + primeNumber + "\"");
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