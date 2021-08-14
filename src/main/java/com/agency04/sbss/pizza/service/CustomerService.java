package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Customer;

import java.util.List;

public interface CustomerService {
    public boolean add(Customer customer);
    public Customer getByUsername(String name);
    public void update(Customer customer);
    public void delete(String name);
    public List<Customer> getAll();
}

