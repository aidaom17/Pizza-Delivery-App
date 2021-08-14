package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.DeliveryOrderForm;
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

    @PostMapping("/order")
    public String newOrder(@RequestBody DeliveryOrderForm deliveryOrderForm){
        return thePizzaDeliveryService.orderPizza(deliveryOrderForm);
    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> listOrders(){
        return thePizzaDeliveryService.getOrders();
    }
}
