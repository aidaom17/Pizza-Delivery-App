package com.agency04.sbss.pizza;


public class DiavolaPizza implements Pizza{
    private ingredients[] ingredientsArray = {ingredients.tomato_sauce, ingredients.mozzarella,
            ingredients.spicy_salami, ingredients.chilli_pepper};
    @Override
    public String getName() {
        return "Diavola Pizza";
    }

    @Override
    public String getIngredients() {
        String result ="";
        for (ingredients ingredient: ingredientsArray) {
            result+= ingredient + " ";
        }
        return result;
    }
}
