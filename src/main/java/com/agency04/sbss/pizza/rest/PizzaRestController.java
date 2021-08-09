package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.Sizes;
import com.agency04.sbss.pizza.model.impl.*;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.impl.PizzaDeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api")
public class PizzaRestController{
    private PizzaObject thePizzaObject;
    @Autowired
    private PizzaDeliveryServiceImpl pizzaDeliveryServiceImpl;

    @PostConstruct
    public void loadPizzas(){
        thePizzaObject = new PizzaObject();

        // add pizza sizes
        List<Sizes> pizzaSizes = Arrays.asList(Sizes.values());
        thePizzaObject.setPizzaSizes(pizzaSizes);

        // add pizzas
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new DiavolaPizza("Diavola Pizza"));
        pizzas.add(new TricolorePizza("Tricolore Pizza"));
        thePizzaObject.setPizzas(pizzas);
    }

    @GetMapping("/pizzeria/menu")
    public PizzaObject getMenu(){
        return thePizzaObject;
    }

    @GetMapping("/pizzeria")
    public PizzeriaService getPizzeria(){
        return pizzaDeliveryServiceImpl.getPizzeriaService();
    }
}
