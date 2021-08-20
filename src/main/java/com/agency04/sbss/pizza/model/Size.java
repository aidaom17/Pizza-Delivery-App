package com.agency04.sbss.pizza.model;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private String size;

    Size(String size) {
        this.size = size;
    }
    public String getValue() {
        return size;
    }
}
