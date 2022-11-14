/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primenumbers;

/**
 *
 * @author misho
 */
import java.util.LinkedList;
import java.util.Queue;

public class Producer extends Thread {
    Queue<Integer> queue = new LinkedList<Integer>();
    int n;
    int size;

    public Producer(int n, int size) {
        this.n = n;
        this.size = size;
    }

    public void run() {
        synchronized (queue) {
            for (int i = 2; i < n; i++) {
                while (queue.size() == size) {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                if (isPrime(i)) {
                    queue.add(i);
                    queue.notifyAll();
                }
            }
            queue.add(-1);
            System.out.println("Producer is done");
        }

    }

    static Boolean isPrime(int n) {
        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
