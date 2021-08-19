package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username){
        return customerService.getByUsername(username);
    }

    @PostMapping
    public void newCustomer(@RequestBody Customer customer){
        customerService.add(customer);
    }

    // pomoćni request
    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
    }

    @DeleteMapping("/{username}")
    public void deleteCustomer(@PathVariable String username){
        customerService.delete(username);
    }
}
