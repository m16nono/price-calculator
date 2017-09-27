package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.Random;

@Service
public class Producer implements Runnable {

    Queue<Double> queue;

    @Autowired
    public Producer(Queue<Double> queue){
        this.queue = queue;
    }

    private Random random = new Random();

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(500);
                double v = random.nextDouble();
                System.out.println("Produced: " + v);
                queue.add(v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

