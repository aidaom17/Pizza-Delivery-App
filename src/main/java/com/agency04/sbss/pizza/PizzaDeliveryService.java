package com.agency04.sbss.pizza;

public class PizzaDeliveryService {
    //private field for dependency injection
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){}

    // constructor for dependency injection
    public PizzaDeliveryService(PizzeriaService thePizzeriaService){
        pizzeriaService = thePizzeriaService;
    }

    // method for setter injection
    public void setPizzeriaService(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    public String orderPizza(Pizza thePizza){
        return "Order for pizzeria: " + pizzeriaService.getName() +
                "\n -- " + thePizza.getName() + ": " + thePizza.getIngredients();
    }

}
