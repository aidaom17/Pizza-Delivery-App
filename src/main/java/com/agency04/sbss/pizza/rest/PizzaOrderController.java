package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.PizzaOrder;
import com.agency04.sbss.pizza.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api/order")
public class PizzaOrderController {
    @Autowired
    private PizzaOrderService thePizzaOrderService;

    @PostMapping
    public void newOrder(@RequestBody PizzaOrder pizzaOrder){
        thePizzaOrderService.add(pizzaOrder);
    }

    @GetMapping("/list")
    public List<PizzaOrder> listOrders(){
        return thePizzaOrderService.getAll();
    }
}
