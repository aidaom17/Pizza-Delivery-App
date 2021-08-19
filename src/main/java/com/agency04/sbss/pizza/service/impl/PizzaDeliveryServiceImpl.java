package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.impl.Delivery;
import com.agency04.sbss.pizza.model.impl.Pizza;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryServiceImpl(){}

    public PizzaDeliveryServiceImpl(PizzeriaService thePizzeriaService){
        this.pizzeriaService = thePizzeriaService;
    }

    @PostConstruct
    public void openDelivery(){
        System.out.println("Pizza delivery is open. You can order your favourite pizzas from " +
                pizzeriaService.getName() + "!");
    }

    @Override
    public PizzeriaService getPizzeriaService() {
        return pizzeriaService;
    }

    @Override
    public String orderPizza(Pizza thePizza) {
        return "Order for: " + pizzeriaService.getName() +
                "\n -- Pizza: " + thePizza.getName() + " (" + thePizza.getIngredients() +
                ")\n -- Making: " + pizzeriaService.makePizza(thePizza) +
                "\n --> Pizza is coming soon!";
    }


    @Override
    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public void add(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @PreDestroy
    public void closeDelivery() {
        System.out.println("Pizza delivery for " + pizzeriaService.getName() +
                " is closed. See you tomorrow!");
    }
}