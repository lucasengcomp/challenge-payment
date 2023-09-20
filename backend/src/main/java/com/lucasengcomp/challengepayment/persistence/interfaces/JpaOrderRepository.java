package com.lucasengcomp.challengepayment.persistence.interfaces;

import com.lucasengcomp.challengepayment.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {
}
