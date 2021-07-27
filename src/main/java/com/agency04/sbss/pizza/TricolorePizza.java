package com.agency04.sbss.pizza;


public class TricolorePizza implements Pizza{
    private ingredients[] ingredientsArray = {ingredients.mozzarella, ingredients.bresaola,
            ingredients.parmesan_flakes};
    @Override
    public String getName() {
        return "Tricolore Pizza";
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
