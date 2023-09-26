package com.lucasengcomp.challengepayment.domain.calculations;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;

public interface PaymentCalculationStrategy {

    void calculateTotalOrder(InsertOrderDeliverDTO dto);

    void calculateTotalOrderPerPerson(InsertOrderDeliverDTO dto);
}
