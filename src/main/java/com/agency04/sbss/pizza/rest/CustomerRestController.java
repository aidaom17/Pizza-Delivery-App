package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.impl.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void loadCustomers(){
        customerService.add(
                new Customer("Lola", "Lolas Street 1", "Lolita19@gmail.com", "111-222-333"));
        customerService.add(
                new Customer("Rio", "Rios Street 91", "Rivero92@gmail.com", "437-249-535"));
        customerService.add(
                new Customer("Luigi", "Luigis Street 5a", "Lugiovanni1@gmail.com","900-142-388"));
    }

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username){
        return customerService.getByUsername(username);
    }

    @PostMapping
    public String newCustomer(@RequestBody Customer customer){
        if(customerService.add(customer))
            return "Customer added successfully!";
        return "Adding customer failed.";
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
