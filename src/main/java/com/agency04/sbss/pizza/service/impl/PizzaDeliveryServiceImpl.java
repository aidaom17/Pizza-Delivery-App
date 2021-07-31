package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
    @PostConstruct
    public void openDelivery(){
        System.out.println("Pizza delivery is open. You can order your favourite pizzas from " +
                pizzeriaService.getName() + "!");
    }

    @PreDestroy
    public void closeDelivery() {
        System.out.println("Pizza delivery for " + pizzeriaService.getName() +
                " is closed. See you tomorrow!");
    }
}
