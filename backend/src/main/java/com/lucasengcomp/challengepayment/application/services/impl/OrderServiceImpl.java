package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
import com.lucasengcomp.challengepayment.domain.calculations.PaymentCalculationStrategy;
import com.lucasengcomp.challengepayment.domain.calculations.RestaurantCalculationStrategy;
import com.lucasengcomp.challengepayment.domain.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderServiceIT {

    private OrderRepository repository;
    private PaymentCalculationStrategy calculationStrategyDeliver;
    private RestaurantCalculationStrategy calculationStrategyRestaurant;

    @Override
    public Page<OrderDTO> findAllPaged(Pageable pageable) {
        return repository.findPageable(pageable);
    }

    @Override
    public OrderDTO findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public InsertOrderDeliverDTO insert(InsertOrderDeliverDTO dto) {
        checkCalculationType(dto);
        return repository.insert(dto);
    }

    private void checkCalculationType(InsertOrderDeliverDTO dto) {
        if (dto.getTypeMeal().equals(TypeMealDTO.RESTAURANT))
            calculateValuesTotalsRestaurant(dto);
        else
            calculateValuesValuesTotalsDeliver(dto);
    }

    private void calculateValuesTotalsRestaurant(InsertOrderDeliverDTO dto) {
        calculationStrategyRestaurant.calculateOrderDetails(dto);
    }

    private void calculateValuesValuesTotalsDeliver(InsertOrderDeliverDTO dto) {
        calculationStrategyDeliver.calculateTotalOrder(dto);
        calculationStrategyDeliver.calculateTotalOrderPerPerson(dto);
    }
}
