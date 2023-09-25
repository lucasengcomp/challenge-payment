package com.lucasengcomp.challengepayment.domain.calculations.impl;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;
import com.lucasengcomp.challengepayment.domain.calculations.RestaurantCalculationStrategy;

import java.math.BigDecimal;

public class RestaurantPaymentCalculationStrategy implements RestaurantCalculationStrategy {

    @Override
    public BigDecimal calculateTotalToPay(InsertOrderDTO dto, BigDecimal totalValue) {
        return null;
    }
}
