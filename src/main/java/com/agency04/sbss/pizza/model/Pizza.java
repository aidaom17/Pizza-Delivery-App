package com.agency04.sbss.pizza.model;

import com.agency04.sbss.pizza.model.impl.DiavolaPizza;
import com.agency04.sbss.pizza.model.impl.TricolorePizza;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DiavolaPizza.class, name = "DiavolaPizza"),
        @JsonSubTypes.Type(value = TricolorePizza.class, name = "TricolorePizza") }
)
public interface Pizza {
    public String getName();
    public String getIngredients();
}
