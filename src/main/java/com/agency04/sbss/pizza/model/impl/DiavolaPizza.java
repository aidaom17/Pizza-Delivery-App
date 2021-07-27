package com.agency04.sbss.pizza.model.impl;

import com.agency04.sbss.pizza.model.Ingredients;
import com.agency04.sbss.pizza.model.Pizza;

import java.util.Set;
import java.util.stream.Collectors;
import static com.agency04.sbss.pizza.model.Ingredients.*;

public class DiavolaPizza implements Pizza {
    private final Set<Ingredients> ingredients =
            Set.of(TOMATO_SAUCE, MOZZARELLA, SPICY_SALAMY, CHILLI_PEPPER);
    @Override
    public String getName() {
        return "Diavola Pizza";
    }
    @Override
    public String getIngredients() {
        return ingredients.stream().map(Ingredients::getValue).
                collect(Collectors.joining(","));

    }
}