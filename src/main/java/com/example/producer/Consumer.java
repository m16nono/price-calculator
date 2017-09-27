package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class Consumer implements Runnable {

    private Queue<Double> queue;
    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public Consumer(Queue<Double> queue, PriceCalculatorService priceCalculatorService) {
        this.queue = queue;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.size() > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Double peek = queue.peek();
                System.out.println("Consumed: " + peek);
                System.out.println("Queue size: " + queue.size());
                System.out.println("Price : " + priceCalculatorService.calculate(peek));
            }
        }
    }
}
