package com.agency04.sbss.pizza;

public class RedPepperPizzeria implements PizzeriaService{
    private String name;
    private String adress;
    private String owner;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.adress;
    }


    @Override
    public String makePizza(Pizza thePizza) {
        return "Making " + thePizza.getName() + " with " + thePizza.getIngredients();
    }
}
