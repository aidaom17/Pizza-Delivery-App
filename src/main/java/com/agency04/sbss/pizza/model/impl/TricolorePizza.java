package com.agency04.sbss.pizza.model.impl;

import com.agency04.sbss.pizza.model.Ingredients;
import com.agency04.sbss.pizza.model.Pizza;

import java.util.Set;
import java.util.stream.Collectors;
import static com.agency04.sbss.pizza.model.Ingredients.*;

public class TricolorePizza implements Pizza {
    private String pizzaName;
    private final Set<Ingredients> ingredients =
            Set.of(MOZZARELLA, BRESAOLA, PARMESAN_FLAKES);

    public TricolorePizza(){};

    public TricolorePizza(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    @Override
    public String getName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    @Override
    public String getIngredients() {
        return ingredients.stream().map(Ingredients::getValue).
                collect(Collectors.joining(","));
    }
}
