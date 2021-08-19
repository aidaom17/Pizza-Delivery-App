package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.impl.PizzaOrder;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import com.agency04.sbss.pizza.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {
    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public void add(PizzaOrder pizzaOrder) {
        pizzaOrderRepository.save(pizzaOrder);
    }

    @Override
    public List<PizzaOrder> getAll() {
        return pizzaOrderRepository.findAll();
    }
}
