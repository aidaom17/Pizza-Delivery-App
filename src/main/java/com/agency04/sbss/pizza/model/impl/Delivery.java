package com.agency04.sbss.pizza.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column
    private Date submissionDate;

    @JsonIgnore
    @OneToMany(mappedBy="delivery", cascade = CascadeType.ALL)
    private List<PizzaOrder> pizzaOrders = new ArrayList<PizzaOrder>();

    public Delivery(){}

    public Delivery(Customer customer, Date submissionDate) {
        this.customer = customer;
        this.submissionDate = submissionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public void addPizzaOrder(PizzaOrder pizzaOrder){
        pizzaOrders.add(pizzaOrder);
        pizzaOrder.setDelivery(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id.hashCode();
        hash = 79 * hash + this.submissionDate.hashCode();
        hash = 79 * hash + this.customer.hashCode();
        hash = 79 * hash + this.pizzaOrders.hashCode();
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
        final Delivery other = (Delivery) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.submissionDate, other.submissionDate)) {
            return false;
        }
        if (!Objects.equals(this.pizzaOrders, other.pizzaOrders)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
