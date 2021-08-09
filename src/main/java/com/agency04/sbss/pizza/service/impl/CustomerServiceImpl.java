package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.model.impl.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerServiceImpl(){};

    public CustomerServiceImpl(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if(customer == null)
            return false;

        customers.add(customer);
        return true;
    }

    @Override
    public Customer getCustomerByUserName(String name) {
        for (Customer customer: customers) {
            if(customer.getName().equals(name)) {
                return customer;
            }
        }
        throw new CustomerNotFoundException();
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer theCustomer = getCustomerByUserName(customer.getName());
        int index = customers.indexOf(theCustomer);
        if (index == -1) {
            throw new CustomerNotFoundException();
        }
        else{
            customers.set(index, customer);
            return;
        }
    }

    @Override
    public void deleteCustomerByUserName(String name) {
        for (Customer customer: customers) {
            if(customer.getName().equals(name)) {
                customers.remove(customer);
                return;
            }
        }
        throw new CustomerNotFoundException();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
