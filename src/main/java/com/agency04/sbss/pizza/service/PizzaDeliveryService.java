package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.impl.DeliveryOrderForm;

import java.util.List;

public interface PizzaDeliveryService {
    public String orderPizza(Pizza thePizza);
    public String orderPizza(DeliveryOrderForm theDeliveryOrderForm);
    public List<DeliveryOrderForm> getOrders();
}
