package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Pizza;

public interface PizzeriaService {
    public String getName();
    public String getAddress();
    public String makePizza(Pizza thePizza);
}
