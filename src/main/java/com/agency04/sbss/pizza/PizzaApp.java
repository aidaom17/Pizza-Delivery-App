package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.impl.DiavolaPizza;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.impl.TricolorePizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

        // testing PostConstruct, PreDestory
        PizzaDeliveryService theFirstPizzaDeliveryService =
                context.getBean("pizzaDeliveryServiceImpl", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        Pizza theDiavolaPizza = new DiavolaPizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theDiavolaPizza));
        Pizza theTricolorePizza = new TricolorePizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theTricolorePizza));

        
        //testing Scope("singleton")
        System.out.println("\nScope(\"singleton\")");
        PizzeriaService theFirstPizzeria = context.getBean("redPepperPizzeria", PizzeriaService.class);
        PizzeriaService theSecondPizzeria = context.getBean("redPepperPizzeria", PizzeriaService.class);

        boolean equal =  (theFirstPizzeria == theSecondPizzeria);
        System.out.println("Pointing to the same object = " + equal);
        System.out.println("Memory location for the first pizzeria " + theFirstPizzeria);
        System.out.println("Memory location for the second pizzeria " + theSecondPizzeria);


        //testing Scope("prototype")
        System.out.println("\nScope(\"prototype\")");
        theFirstPizzeria = context.getBean("allStarPizzeria", PizzeriaService.class);
        theSecondPizzeria = context.getBean("allStarPizzeria", PizzeriaService.class);

        equal =  (theFirstPizzeria == theSecondPizzeria);
        System.out.println("Pointing to the same object = " + equal);
        System.out.println("Memory location for the first pizzeria " + theFirstPizzeria);
        System.out.println("Memory location for the second pizzeria " + theSecondPizzeria);

        context.close();
    }
}
