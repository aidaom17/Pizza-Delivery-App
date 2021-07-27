package com.agency04.sbss.pizza;

enum ingredients{
    tomato_sauce, mozzarella, spicy_salami, chilli_pepper,
    bresaola, parmesan_flakes
}
public interface Pizza {
    public String getName();
    public String getIngredients();
}
