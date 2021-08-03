package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.impl.DiavolaPizza;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.impl.TricolorePizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PizzaApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PizzaApp.class, args);

        PizzaDeliveryService thePizzaDeliveryService =
                context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        Pizza theDiavolaPizza = new DiavolaPizza();
        System.out.println(thePizzaDeliveryService.orderPizza(theDiavolaPizza));
        Pizza theTricolorePizza = new TricolorePizza();
        System.out.println(thePizzaDeliveryService.orderPizza(theTricolorePizza));

        //testing allStarPizzeria bean
        PizzeriaService newPizzeria = context.getBean("allStarPizzeria", PizzeriaService.class);
        System.out.println(newPizzeria.makePizza(theDiavolaPizza));
    }
}
