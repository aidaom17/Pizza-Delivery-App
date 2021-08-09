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
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void loadCustomers(){
        customerService.addCustomer(
                new Customer("Lola", "Lolas Street 1", "Lolita19@gmail.com", "111-222-333"));
        customerService.addCustomer(
                new Customer("Rio", "Rios Street 91", "Rivero92@gmail.com", "437-249-535"));
        customerService.addCustomer(
                new Customer("Luigi", "Luigis Street 5a", "Lugiovanni1@gmail.com","900-142-388"));
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username){
        return customerService.getCustomerByUserName(username);
    }

    @PostMapping("/customer")
    public String newCustomer(@RequestBody Customer customer){
        if(customerService.addCustomer(customer))
            return "Customer added successfully!";
        return "Adding customer failed.";
    }

    // pomoćni request
    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{username}")
    public void deleteCustomer(@PathVariable String username){
        customerService.deleteCustomerByUserName(username);
    }
}
