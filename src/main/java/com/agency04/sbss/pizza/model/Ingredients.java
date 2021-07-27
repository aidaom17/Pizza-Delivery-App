package com.agency04.sbss.pizza.model;

public enum Ingredients {
    TOMATO_SAUCE("Tomato Sauce"),
    MOZZARELLA("Mozzarella"),
    SPICY_SALAMY("Spicy salamy"),
    CHILLI_PEPPER("Chilli pepper"),
    BRESAOLA("Bresaola"),
    PARMESAN_FLAKES("Parmesan flakes");

    private String ingredient;

    Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }
    public String getValue() {
        return ingredient;
    }
}
