package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Pizza;

import java.util.List;

public interface PizzaService {
    public void add(Pizza pizza);
    public List<Pizza> getAll();
}
