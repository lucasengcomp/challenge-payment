package com.lucasengcomp.challengepayment.domain.calculations;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;

public interface RestaurantCalculationStrategy {

    void calculateOrderDetails(InsertOrderDeliverDTO dto);
}
