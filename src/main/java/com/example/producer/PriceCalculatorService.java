package com.example.producer;


import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorService {

    private double closePrice = 1.5;
    private double prenium = 0.5;
    private double delta = 1d;

    public double calculate(double price){
        return (closePrice - price) * delta + prenium;
    }
}
