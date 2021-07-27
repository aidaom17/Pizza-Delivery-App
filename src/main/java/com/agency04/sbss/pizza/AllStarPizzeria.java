package com.agency04.sbss.pizza;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AllStarPizzeria implements PizzeriaService{
    @Value("${pizzeria.name}")
    private String name;
    @Value("${pizzeria.address}")
    private String address;
    @Value("${pizzeria.owner}")
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
        return "Pizzeria " + name + " at address " + address + " ( Owner: " +
                owner + ") " +  "is making: " + thePizza.getName() + " with " + thePizza.getIngredients();
    }
}
