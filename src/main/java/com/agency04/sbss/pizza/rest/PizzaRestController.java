package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Size;
import com.agency04.sbss.pizza.model.impl.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzaService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@RestController
@EnableWebMvc
@RequestMapping("/api/pizzeria")
public class PizzaRestController{
    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/menu")
    public Menu getMenu(){
        Menu theMenu = new Menu();
        theMenu.setPizzaSizes(Arrays.asList(Size.values()));
        theMenu.setPizzas(getAllPizzas());
        return theMenu;
    }

    @GetMapping
    public PizzeriaService getPizzeria(){
        return pizzaDeliveryService.getPizzeriaService();
    }

    @GetMapping("/all")
    public List<Pizza> getAllPizzas(){
        return pizzaService.getAll();
    }
}
