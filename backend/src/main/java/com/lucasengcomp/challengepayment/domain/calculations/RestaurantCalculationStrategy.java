package com.lucasengcomp.challengepayment.domain.calculations;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;

import java.math.BigDecimal;

public interface RestaurantCalculationStrategy {

    BigDecimal calculateTotalToPay(InsertOrderDTO dto, BigDecimal totalValue);
}
