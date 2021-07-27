package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {
    @Autowired
    @Qualifier("redPepperPizzeria")
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryServiceImpl(){}

    @Override
    public String orderPizza(Pizza thePizza) {
        return "Order for: " + pizzeriaService.getName() +
                "\n -- Pizza: " + thePizza.getName() + " (" + thePizza.getIngredients() +
                ")\n -- Making: " + pizzeriaService.makePizza(thePizza) +
                "\n --> Pizza is coming soon!";
    }
}
