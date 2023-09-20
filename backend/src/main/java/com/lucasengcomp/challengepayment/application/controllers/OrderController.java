package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.OrderDTO;
import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
import com.lucasengcomp.challengepayment.application.services.PersonServiceIT;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private OrderServiceIT service;

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> findPaged(Pageable pageable) {
        Page<OrderDTO> allPleople = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(allPleople);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO person = service.findById(id);
        return ResponseEntity.ok().body(person);
    }
}
