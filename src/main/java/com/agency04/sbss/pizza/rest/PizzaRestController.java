package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.Sizes;
import com.agency04.sbss.pizza.model.impl.*;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api/pizzeria")
public class PizzaRestController{
    private Menu theMenu;
    @Autowired
    private PizzaDeliveryService pizzaDeliveryService;

    @PostConstruct
    public void loadPizzas(){
        theMenu = new Menu();

        // add pizza sizes
        List<Sizes> pizzaSizes = Arrays.asList(Sizes.values());
        theMenu.setPizzaSizes(pizzaSizes);

        // add pizzas
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new DiavolaPizza("Diavola Pizza"));
        pizzas.add(new TricolorePizza("Tricolore Pizza"));
        theMenu.setPizzas(pizzas);
    }

    @GetMapping("/menu")
    public Menu getMenu(){
        return theMenu;
    }

    @GetMapping
    public PizzeriaService getPizzeria(){
        return pizzaDeliveryService.getPizzeriaService();
    }
}
