package com.agency04.sbss.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PizzaApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PizzaApp.class, args);
    }
}
