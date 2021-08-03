package com.agency04.sbss.pizza.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello! Do you want some pizzas? :)";
    }
}
