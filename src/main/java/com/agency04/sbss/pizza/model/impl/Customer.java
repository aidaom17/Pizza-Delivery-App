package com.agency04.sbss.pizza.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customerDetails_id")
    private CustomerDetails customerDetails;

    @JsonIgnore
    @OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
    private List<Delivery> deliveries = new ArrayList<Delivery>();

    public Customer(){};

    public Customer(String username, CustomerDetails customerDetails)
    {
        this.username = username;
        this.customerDetails = customerDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void addDeliveryToCustomer(Delivery delivery){
        deliveries.add(delivery);
        delivery.setCustomer(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id.hashCode();
        hash = 79 * hash + this.username.hashCode();
        hash = 79 * hash + this.customerDetails.hashCode();
        hash = 79 * hash + this.deliveries.hashCode();
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.customerDetails, other.customerDetails)) {
            return false;
        }
        if (!Objects.equals(this.deliveries, other.deliveries)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
