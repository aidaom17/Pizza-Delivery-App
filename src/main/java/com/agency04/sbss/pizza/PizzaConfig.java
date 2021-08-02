package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.impl.AllStarPizzeria;
import com.agency04.sbss.pizza.service.impl.PizzaDeliveryServiceImpl;
import com.agency04.sbss.pizza.service.impl.RedPepperPizzeria;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

   @Bean
    public PizzeriaService allStarPizzeriaBean() {
        return new AllStarPizzeria();
    }

    @Bean
    @Primary
    public PizzeriaService redPepperPizzeriaBean(){
        return new RedPepperPizzeria();
    }

    @Bean
    public PizzaDeliveryService pizzaDeliveryServiceImplBean(){
        PizzaDeliveryServiceImpl myPizzaDeliveryServiceImpl =
                new PizzaDeliveryServiceImpl(redPepperPizzeriaBean());
        return myPizzaDeliveryServiceImpl;
    }

}
