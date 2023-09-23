package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.OrderDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private OrderServiceIT service;

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> findPaged(Pageable pageable) {
        Page<OrderDTO> allOrders = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(allOrders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping
    public ResponseEntity<InsertOrderDTO> insert(@RequestBody InsertOrderDTO dto) {
        InsertOrderDTO inserted = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(inserted);
    }
}
