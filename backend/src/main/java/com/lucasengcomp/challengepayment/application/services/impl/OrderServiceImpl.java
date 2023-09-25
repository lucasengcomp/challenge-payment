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
import java.math.RoundingMode;

import static com.lucasengcomp.challengepayment.application.util.BigDecimalConstants.DEFAULT_SCALE_2;

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

        dto.setTotal(totalValue.setScale(2, RoundingMode.HALF_UP));
        dto.setTotalToPay(calculateTotalToPayPerOrder(dto, totalValue));
    }

    private void calculateTotalOrderPerPerson(InsertOrderDTO dto) {
        for (InsertPersonDTO person : dto.getPeople()) {
            BigDecimal totalValue = BigDecimal.ZERO;

            for (ItemDTO item : person.getItems()) {
                totalValue = totalValue.add(item.getPrice());
            }

            BigDecimal totalToPay = calculateTotalToPayPerPerson(totalValue,
                    calculateFreightPerPerson(dto, totalValue),
                    calculateDiscountPerPerson(dto, totalValue));

            totalToPay.setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP);

            person.setTotal(totalValue);
            person.setTotalToPay(totalToPay);
        }
    }

    private static BigDecimal calculateTotalToPayPerOrder(InsertOrderDTO dto, BigDecimal totalValue) {
        return totalValue
                .add(dto.getDeliver().getTax())
                .subtract(dto.getDeliver().getDiscount())
                .setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateTotalToPayPerPerson(BigDecimal totalValue, BigDecimal frete, BigDecimal discount) {
        return totalValue.add(frete).subtract(discount);
    }

    private static BigDecimal calculateDiscountPerPerson(InsertOrderDTO dto, BigDecimal totalValue) {
        return totalValue.multiply(dto.getDeliver().getDiscount())
                .divide(dto.getTotal(), DEFAULT_SCALE_2, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateFreightPerPerson(InsertOrderDTO dto, BigDecimal totalValue) {
        return totalValue.multiply(dto.getDeliver().getTax())
                .divide(dto.getTotal(), DEFAULT_SCALE_2, RoundingMode.HALF_UP);
    }
}
