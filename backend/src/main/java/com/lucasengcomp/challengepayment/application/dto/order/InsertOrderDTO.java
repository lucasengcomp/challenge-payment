package com.lucasengcomp.challengepayment.application.dto.order;

import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.enums.PaymentMethod;
import com.lucasengcomp.challengepayment.domain.enums.TypeMeal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class InsertOrderDTO {

    private Long id;
    private BigDecimal totalValue;
    private BigDecimal totalToPay;
    private PaymentMethod paymentMethod;
    private Long personId;
    private Deliver deliver;
    private BigDecimal taxRate;
    private TypeMeal typeMeal;
    private BigDecimal calculatedTotalToPay;
}
