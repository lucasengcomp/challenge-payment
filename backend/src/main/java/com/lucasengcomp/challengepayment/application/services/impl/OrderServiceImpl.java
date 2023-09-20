package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.OrderDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
import com.lucasengcomp.challengepayment.domain.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderServiceIT {

    private OrderRepository repository;


    @Override
    public Page<OrderDTO> findAllPaged(Pageable pageable) {
        return repository.findPageable(pageable);
    }

    @Override
    public OrderDTO findById(Long id) {
        return repository.findById(id);
    }
}
