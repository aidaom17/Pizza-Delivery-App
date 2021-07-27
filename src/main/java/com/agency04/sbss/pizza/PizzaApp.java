package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        // testing for first pizzeria
        PizzaDeliveryService theFirstPizzaDeliveryService =
                context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        Pizza theDiavolaPizza = new DiavolaPizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theDiavolaPizza));
        Pizza theTricolorePizza = new TricolorePizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theTricolorePizza));

        context.close();
    }
}
