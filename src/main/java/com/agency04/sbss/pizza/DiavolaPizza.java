package com.agency04.sbss.pizza;

import org.springframework.stereotype.Component;

@Component
public class DiavolaPizza implements Pizza{

    @Override
    public String getName() {
        return "Diavola Pizza";
    }

    @Override
    public String getIngredients() {
        return "Tomato sauce, mozzarella, spicy salami, and chilli pepper.";
    }
}
