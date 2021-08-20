package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.PizzaOrder;

import java.util.List;

public interface PizzaOrderService {
    public void add(PizzaOrder pizzaOrder);
    public List<PizzaOrder> getAll();
}
