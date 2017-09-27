package com.example.producer;

import com.google.common.collect.EvictingQueue;
import com.google.common.collect.Queues;
import org.omg.CORBA.PrincipalHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Queue;

@ComponentScan
@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Bean
	public Queue<Double> queue(){
	  return Queues.synchronizedQueue(EvictingQueue.create(10));
	}
}

