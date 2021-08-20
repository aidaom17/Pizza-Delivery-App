package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api/delivery")
public class DeliveryRestController{
    @Autowired
    private PizzaDeliveryService thePizzaDeliveryService;

    @PostMapping("/order")
    public ResponseEntity<Delivery> newDelivery(@RequestBody Delivery delivery){
        try {
            Delivery theDelivery = thePizzaDeliveryService.createOrUpdate(delivery);
            return new ResponseEntity<Delivery>(theDelivery, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public List<Delivery> listDeliveries(){
        return thePizzaDeliveryService.getDeliveries();
    }
}

