package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.impl.DiavolaPizza;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.impl.TricolorePizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzaApp implements CommandLineRunner{

    private AnnotationConfigApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        PizzaDeliveryService theFirstPizzaDeliveryService =
                context.getBean("pizzaDeliveryServiceImplBean", PizzaDeliveryService.class);

        System.out.println("Testing first pizzeria");
        Pizza theDiavolaPizza = new DiavolaPizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theDiavolaPizza));
        Pizza theTricolorePizza = new TricolorePizza();
        System.out.println(theFirstPizzaDeliveryService.orderPizza(theTricolorePizza));

        // testing allStarPizzeria bean and annotation @PropertySource
        PizzeriaService newPizzeria = context.getBean("allStarPizzeriaBean", PizzeriaService.class);
        System.out.println(newPizzeria.makePizza(theDiavolaPizza));

        context.close();
    }

    public static void main(String[] args) {
        SpringApplication.run(PizzaApp.class, args);
    }
}
