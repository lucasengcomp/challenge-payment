package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
import com.lucasengcomp.challengepayment.domain.calculations.PaymentCalculationStrategy;
import com.lucasengcomp.challengepayment.domain.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderServiceIT {

    private OrderRepository repository;

    private PaymentCalculationStrategy calculationStrategy;

    @Override
    public Page<OrderDTO> findAllPaged(Pageable pageable) {
        return repository.findPageable(pageable);
    }

    @Override
    public OrderDTO findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public InsertOrderDTO insert(InsertOrderDTO dto) {
        calculateValuesTotalsOrdersAndPeople(dto);
        return repository.insert(dto);
    }

    private void calculateValuesTotalsOrdersAndPeople(InsertOrderDTO dto) {
        calculationStrategy.calculateTotalOrder(dto);
        calculationStrategy.calculateTotalOrderPerPerson(dto);
    }
}
