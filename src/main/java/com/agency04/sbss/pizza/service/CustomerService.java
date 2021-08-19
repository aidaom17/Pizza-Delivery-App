package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Customer;

import java.util.List;

public interface CustomerService {
    //public void add(Customer customer);
    public Customer getByUsername(String username);
    public Customer createOrUpdate(Customer customer);
    public void delete(String name);
    public List<Customer> getAll();
}

