package com.lucasengcomp.challengepayment.persistence.interfaces;

import com.lucasengcomp.challengepayment.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Person, Long> {
}
