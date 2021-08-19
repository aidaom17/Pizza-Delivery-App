package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Size;
import com.agency04.sbss.pizza.model.impl.*;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.repository.DeliveryRepository;
import com.agency04.sbss.pizza.repository.PizzaOrderRepository;
import com.agency04.sbss.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static com.agency04.sbss.pizza.model.Ingredients.*;
import static com.agency04.sbss.pizza.model.Ingredients.CHILLI_PEPPER;

@SpringBootApplication
public class PizzaApp implements CommandLineRunner {
    @Autowired
    PizzaOrderRepository pizzaOrderRepository;
    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PizzaApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Customer Lola = new Customer("Lolita19",
                new CustomerDetails("Lola", "Lolas","111-222-333"));
        Customer Rio = new Customer("Rio92",
                new CustomerDetails("Rio", "Rios", "437-249-535"));
        Customer Luigi = new Customer("Lugiovanni1",
                new CustomerDetails("Luigi", "Luigis", "900-142-388"));

        Pizza diavola = new Pizza("DiavolaPizza",
                Set.of(TOMATO_SAUCE, MOZZARELLA, SPICY_SALAMY, CHILLI_PEPPER));
        Pizza tricolore = new Pizza("TricolorePizza",
                Set.of(MOZZARELLA, BRESAOLA, PARMESAN_FLAKES));

        PizzaOrder smallDiavola = new PizzaOrder(diavola,"3", Size.SMALL);
        diavola.addPizzaOrderToPizza(smallDiavola);

        PizzaOrder largeTricolore = new PizzaOrder(tricolore, "10", Size.LARGE);
        tricolore.addPizzaOrderToPizza(largeTricolore);

        Delivery delivery = new Delivery();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("31-08-2020");
        delivery.setSubmissionDate(date);

        delivery.addPizzaOrder(smallDiavola);
        delivery.addPizzaOrder(largeTricolore);

        Lola.addDeliveryToCustomer(delivery);

        pizzaRepository.save(tricolore);
        pizzaRepository.save(diavola);
        pizzaOrderRepository.save(smallDiavola);
        pizzaOrderRepository.save(largeTricolore);
        deliveryRepository.save(delivery);
        customerRepository.save(Lola);
        customerRepository.save(Luigi);
        customerRepository.save(Rio);
    }
}
