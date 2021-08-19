package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.impl.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
