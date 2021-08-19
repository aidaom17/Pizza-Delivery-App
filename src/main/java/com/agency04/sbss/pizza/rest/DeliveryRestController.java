package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api/delivery")
public class DeliveryRestController{
    @Autowired
    private PizzaDeliveryService thePizzaDeliveryService;

    @PostMapping
    public void newDelivery(@RequestBody Delivery delivery){
        thePizzaDeliveryService.add(delivery);
    }

    @GetMapping("/list")
    public List<Delivery> listDeliveries(){
        return thePizzaDeliveryService.getDeliveries();
    }
}

