package com.agency04.sbss.pizza.model.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.Sizes;

import java.util.List;

public class Menu {
    private List<Sizes> pizzaSizes;
    private List<Pizza> pizzas;

    public List<Sizes> getPizzaSizes() {
        return pizzaSizes;
    }

    public void setPizzaSizes(List<Sizes> pizzaSizes) {
        this.pizzaSizes = pizzaSizes;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
