package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.impl.Pizza;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import com.agency04.sbss.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public void add(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
    @Override
    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }
}
