package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Delivery;
import com.agency04.sbss.pizza.model.impl.Pizza;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PizzaDeliveryService {
    public String orderPizza(Pizza thePizza);
    public PizzeriaService getPizzeriaService();
    public List<Delivery> getDeliveries();
    public Delivery createOrUpdate(Delivery delivery);
}
