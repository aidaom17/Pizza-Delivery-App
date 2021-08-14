package com.agency04.sbss.pizza.model;

public enum Sizes {
    MINI("Mini pizza (8 inches)"),
    SMALL("Small pizza (10 inches)"),
    MEDIUM("Medium pizza (12 inches)"),
    LARGE("Large pizza (16 inches)"),
    JUMBO("Jumbo pizza (20 inches)");

    private String size;

    Sizes(String size) {
        this.size = size;
    }
    public String getValue() {
        return size;
    }
}
