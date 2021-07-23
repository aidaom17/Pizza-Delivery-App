package com.agency04.sbss.pizza;

public interface Pizza {
    public static enum ingredients{
        mozzarella, pepperoni, bacon, ham, mushrooms, olives, pineapple
    }
    public String getName();
    public String getIngredients();
}
