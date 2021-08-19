package com.agency04.sbss.pizza.model.impl;

import com.agency04.sbss.pizza.model.Size;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="pizzaOrder")
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="pizza_id")
    private Pizza pizza;

    @Column
    private String quantity;

    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    public PizzaOrder(){};

    public PizzaOrder(Pizza pizza, String quantity, Size size) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id.hashCode();
        hash = 79 * hash + this.quantity.hashCode();
        hash = 79 * hash + this.size.hashCode();
        hash = 79 * hash + this.pizza.hashCode();
        hash = 79 * hash + this.delivery.hashCode();
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
        final PizzaOrder other = (PizzaOrder) obj;
        if (!Objects.equals(this.pizza, other.pizza)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.delivery, other.delivery)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
