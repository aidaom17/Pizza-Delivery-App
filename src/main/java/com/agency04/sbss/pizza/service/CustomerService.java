package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.impl.Customer;

import java.util.List;

public interface CustomerService {
    public boolean addCustomer(Customer customer);
    public Customer getCustomerByUserName(String name);
    public void updateCustomer(Customer customer);
    public void deleteCustomerByUserName(String name);
    public List<Customer> getAllCustomers();
}
