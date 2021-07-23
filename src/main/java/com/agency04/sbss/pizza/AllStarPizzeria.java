package com.agency04.sbss.pizza;

public class AllStarPizzeria implements PizzeriaService{
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
        return "All Star Pizzeria";
    }

    @Override
    public String getAddress() {
        return "Stella Stellini 17";
    }

    @Override
    public String makePizza(Pizza thePizza) {
        return "Making: " + thePizza.getName() + " with " + thePizza.getIngredients();
    }
}
