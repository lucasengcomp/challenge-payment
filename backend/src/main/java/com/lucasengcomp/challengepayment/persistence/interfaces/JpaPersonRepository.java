package com.lucasengcomp.challengepayment.persistence.interfaces;

import com.lucasengcomp.challengepayment.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<Person, Long> {
}
