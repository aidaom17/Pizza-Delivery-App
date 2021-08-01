package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.impl.DiavolaPizza;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.impl.TricolorePizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PizzaApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PizzaConfig.class);

        PizzaDeliveryService theFirstPizzaDeliveryService =
                context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        Pizza theDiavolaPizza = new DiavolaPizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theDiavolaPizza));
        Pizza theTricolorePizza = new TricolorePizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theTricolorePizza));


        // testing allStarPizzeria bean and annotation @PropertySource
        PizzeriaService newPizzeria = context.getBean("allStarPizzeria", PizzeriaService.class);
        System.out.println(newPizzeria.makePizza(theDiavolaPizza));

        context.close();
    }
}
