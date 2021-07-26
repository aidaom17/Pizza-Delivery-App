package com.agency04.sbss.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryService {
    //private field for dependency injection
    @Autowired
    @Qualifier("redPepperPizzeria")
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){}

    public String orderPizza(Pizza thePizza){
        return "Order for pizzeria: " + pizzeriaService.getName() +
                "\n -- " + thePizza.getName() + ": " + thePizza.getIngredients();
    }
}
