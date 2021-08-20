package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.impl.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Optional<Customer> findByUsername(String username);
}
