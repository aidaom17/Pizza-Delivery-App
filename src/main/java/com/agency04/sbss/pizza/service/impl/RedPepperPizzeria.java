package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.impl.Pizza;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Value;

public class RedPepperPizzeria implements PizzeriaService {
    @Value("Red Pepper Pizzeria")
    private String name;
    @Value("Peperoni Rossi 17")
    private String address;
    @Value("Peperossi")
    private String owner;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public String makePizza(Pizza thePizza) {
        return "Pizzeria " + name + " (Address: " + address + ", Owner: " +
                owner + ") " +  "is making: " + thePizza.getName() + " with " + thePizza.getIngredients();
    }
}
