package com.lucasengcomp.challengepayment.domain.calculations;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;

public interface PaymentCalculationStrategy {

    void calculateTotalOrder(InsertOrderDTO dto);

    void calculateTotalOrderPerPerson(InsertOrderDTO dto);
}
