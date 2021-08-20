package com.agency04.sbss.pizza.model.impl;

import com.agency04.sbss.pizza.model.Ingredients;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ElementCollection(targetClass=Ingredients.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable
    private Set<Ingredients> ingredients;

    @JsonIgnore
    @OneToMany(mappedBy="pizza", cascade = CascadeType.ALL)
    private List<PizzaOrder> pizzaOrders = new ArrayList<PizzaOrder>();

    public Pizza(){};

    public Pizza(String name, Set<Ingredients> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public void addPizzaOrderToPizza(PizzaOrder pizzaOrder){
        pizzaOrders.add(pizzaOrder);
        pizzaOrder.setPizza(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id.hashCode();
        hash = 79 * hash + this.name.hashCode();
        hash = 79 * hash + this.pizzaOrders.hashCode();
        hash = 79 * hash + this.ingredients.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pizza other = (Pizza) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        if (!Objects.equals(this.pizzaOrders, other.pizzaOrders)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
