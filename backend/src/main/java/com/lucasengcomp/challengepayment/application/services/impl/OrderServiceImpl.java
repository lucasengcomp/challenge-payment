package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
import com.lucasengcomp.challengepayment.domain.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    @Override
    public InsertOrderDTO insert(InsertOrderDTO dto) {
        calculateTotalOrder(dto);
        calculateTotalOrderPerPerson(dto);
        return repository.insert(dto);
    }

    private void calculateTotalOrder(InsertOrderDTO dto) {
        BigDecimal totalValue = BigDecimal.ZERO;
        for (InsertPersonDTO person : dto.getPeople()) {
            for (ItemDTO item : person.getItems()) {
                totalValue = totalValue.add(item.getPrice());
            }
        }
        dto.setTotal(totalValue);
        dto.setTotalToPay(totalValue.add(dto.getDeliver().getTax()).subtract(dto.getDeliver().getDiscount()));
    }

    private void calculateTotalOrderPerPerson(InsertOrderDTO dto) {
        BigDecimal totalValue;
        for (InsertPersonDTO person : dto.getPeople()) {
            totalValue = BigDecimal.ZERO;
            for (ItemDTO item : person.getItems()) {
                totalValue = totalValue.add(item.getPrice());
            }
            BigDecimal tax = totalValue.divide(dto.getTotal()).multiply(dto.getDeliver().getTax());
            BigDecimal discount = totalValue.divide(dto.getTotal()).multiply(dto.getDeliver().getDiscount());
            BigDecimal totalPayment = totalValue.add(tax).subtract(discount);

            person.setTotalPayment(totalPayment);
        }
    }
}
