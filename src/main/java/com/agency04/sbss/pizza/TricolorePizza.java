package com.agency04.sbss.pizza;

public class TricolorePizza implements Pizza{
    @Override
    public String getName() {
        return "Tricolore Pizza";
    }

    @Override
    public String getIngredients() {
        return "Mozzarella, bresaola, and parmesan flakes.";
    }
}
