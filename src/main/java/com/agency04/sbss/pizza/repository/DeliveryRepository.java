package com.agency04.sbss.pizza.repository;

import com.agency04.sbss.pizza.model.impl.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
