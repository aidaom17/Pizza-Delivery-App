package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Delivery;
import com.agency04.sbss.pizza.model.impl.Pizza;

import java.util.List;

public interface PizzaDeliveryService {
    public String orderPizza(Pizza thePizza);
    public PizzeriaService getPizzeriaService();
    public List<Delivery> getDeliveries();
    public void add(Delivery delivery);
}
