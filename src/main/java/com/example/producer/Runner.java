package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Runner {

    private Consumer consumer;
    private Producer producer;

    @Autowired
    public Runner(Consumer consumer, Producer producer) {
        this.consumer = consumer;
        this.producer = producer;
    }

    @PostConstruct
    public void init(){
        Thread consume = new Thread(consumer);
        Thread produce = new Thread(producer);

        produce.start();
        consume.start();

    }
}
