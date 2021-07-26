package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        // pizzas
        Pizza theDiavolaPizza = context.getBean("diavolaPizza", DiavolaPizza.class);
        Pizza theTricolorePizza = context.getBean("tricolorePizza", TricolorePizza.class);

        // deliveries - testing
        PizzaDeliveryService theFirstDelivery =
                context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        System.out.println(theFirstDelivery.orderPizza(theDiavolaPizza));
        System.out.println(theFirstDelivery.orderPizza(theTricolorePizza));

        context.close();
    }
}
