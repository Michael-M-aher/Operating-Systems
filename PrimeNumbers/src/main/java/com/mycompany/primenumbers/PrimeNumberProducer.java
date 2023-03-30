package com.mycompany.primenumbers;

import java.util.LinkedList;
import java.util.Queue;

public class PrimeNumberProducer extends Thread {
    Queue<Integer> primeNumberBuffer = new LinkedList<Integer>();
    int n;
    int size;

    public PrimeNumberProducer(int n, int size) {
        this.n = n;
        this.size = size;
    }

    public void run() {
        synchronized (primeNumberBuffer) {
            for (int i = 2; i < n; i++) {
                while (primeNumberBuffer.size() == size) {
                    try {
                        primeNumberBuffer.wait();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                if (isPrime(i)) {
                    primeNumberBuffer.add(i);
                    primeNumberBuffer.notifyAll();
                }
            }
            primeNumberBuffer.add(-1);
            System.out.println("Producer is done");
        }

    }

    static Boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
