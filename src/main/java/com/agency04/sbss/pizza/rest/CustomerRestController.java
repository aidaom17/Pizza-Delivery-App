package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Customer> newCustomer(@RequestBody Customer customer){
        try{
            Customer theCustomer = customerService.createOrUpdate(customer);
            return new ResponseEntity<Customer>(theCustomer, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pomoćni request
    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        try {
            Customer theCustomer = customerService.createOrUpdate(customer);
            return new ResponseEntity<Customer>(theCustomer, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{username}")
    public void deleteCustomer(@PathVariable String username){
        customerService.delete(username);
    }
}
