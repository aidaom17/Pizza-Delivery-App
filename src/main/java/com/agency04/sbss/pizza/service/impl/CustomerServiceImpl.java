package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.exception.CustomerNotFoundException;
import com.agency04.sbss.pizza.model.impl.Customer;
import com.agency04.sbss.pizza.repository.CustomerRepository;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(){};

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getByUsername(String name) {
     Optional<Customer> result = customerRepository.findByUsername(name);
        Customer theCustomer = null;
        if(result.isPresent()){
            theCustomer = result.get();
        }
        else{
            throw new CustomerNotFoundException();
        }
        return theCustomer;
    }

    @Override
    public void update(Customer customer) {
        Optional<Customer> result =
                customerRepository.findByUsername(customer.getUsername());
        Customer theCustomer = null;
        if(result.isPresent()){
            theCustomer = result.get();
            theCustomer.setCustomerDetails(customer.getCustomerDetails());
            customerRepository.save(theCustomer);
        }
        else{
            customerRepository.save(customer);
        }
    }

    @Override
    public void delete(String name) {
        Customer customer = getByUsername(name);
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
