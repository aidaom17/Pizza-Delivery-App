package com.agency04.sbss.pizza;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedPepperPizzeria implements PizzeriaService{
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


    @Override
    public String makePizza(Pizza thePizza) {
        return "Making " + thePizza.getName() + " with " + thePizza.getIngredients();
    }
}
