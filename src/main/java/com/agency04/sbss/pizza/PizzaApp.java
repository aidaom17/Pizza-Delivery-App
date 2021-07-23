package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

public class PizzaApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        // pizzas
        Pizza theDiavolaPizza = context.getBean("myDiavolaPizza", DiavolaPizza.class);
        Pizza theTricolorePizza = context.getBean("myTricolorePizza", TricolorePizza.class);

        // deliveries - testing
        PizzaDeliveryService theFirstDelivery =
                context.getBean("myFirstDelivery", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        System.out.println(theFirstDelivery.orderPizza(theDiavolaPizza));
        System.out.println(theFirstDelivery.orderPizza(theTricolorePizza));

        System.out.println("\n");

        PizzaDeliveryService theSecondDelivery =
                context.getBean("mySecondDelivery", PizzaDeliveryService.class);

        System.out.println("Testing second pizzeria");
        System.out.println(theSecondDelivery.orderPizza(theDiavolaPizza));
        System.out.println(theSecondDelivery.orderPizza(theTricolorePizza));

        context.close();
    }
}
