package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.impl.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long> {
}
