package com.lucasengcomp.challengepayment.application.dto;

import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private BigDecimal totalValue;

    private BigDecimal totalToPay;

    private PaymentMethod paymentMethod;

    private Long personId;

    private Deliver deliver;
}
