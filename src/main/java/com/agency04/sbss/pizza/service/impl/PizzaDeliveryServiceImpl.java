package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.exception.PizzaNotFoundException;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.impl.DeliveryOrderForm;
import com.agency04.sbss.pizza.model.impl.DiavolaPizza;
import com.agency04.sbss.pizza.model.impl.TricolorePizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {
    List<DeliveryOrderForm> theOrders = new ArrayList<DeliveryOrderForm>();

    @Autowired
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryServiceImpl(){}

    public PizzaDeliveryServiceImpl(PizzeriaService thePizzeriaService){
        this.pizzeriaService = thePizzeriaService;
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
    public String orderPizza(DeliveryOrderForm theDeliveryOrderForm) {
        if (theDeliveryOrderForm.getPizza() instanceof DiavolaPizza ||
                theDeliveryOrderForm.getPizza() instanceof TricolorePizza){
            theOrders.add(theDeliveryOrderForm);
            return "Pizza is ordered";
        }
        else {
            throw new PizzaNotFoundException();
        }
    }

    @Override
    public List<DeliveryOrderForm> getOrders() {
        return theOrders;
    }

    @PostConstruct
    public void openDelivery(){
        System.out.println("Pizza delivery is open. You can order your favourite pizzas from " +
                pizzeriaService.getName() + "!");
    }

    @PreDestroy
    public void closeDelivery() {
        System.out.println("Pizza delivery for " + pizzeriaService.getName() +
                " is closed. See you tomorrow!");
    }
}