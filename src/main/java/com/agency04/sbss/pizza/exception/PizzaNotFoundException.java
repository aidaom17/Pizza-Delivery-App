package com.agency04.sbss.pizza.exception;

public class PizzaNotFoundException extends RuntimeException {
    public PizzaNotFoundException(){
        super("Pizza not found.");
    }
}
