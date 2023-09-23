package com.lucasengcomp.challengepayment.persistence.interfaces;

import com.lucasengcomp.challengepayment.domain.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaItemRepository extends JpaRepository<Item, Long> {
}
