package com.agency04.sbss.pizza.model.impl;

import com.agency04.sbss.pizza.model.Size;

import java.util.List;

public class Menu {
    private List<Size> pizzaSizes;
    private List<Pizza> pizzas;

    public List<Size> getPizzaSizes() {
        return pizzaSizes;
    }

    public void setPizzaSizes(List<Size> pizzaSizes) {
        this.pizzaSizes = pizzaSizes;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
