package com.agency04.sbss.pizza.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(){
        super("Customer not found.");
    }
}
