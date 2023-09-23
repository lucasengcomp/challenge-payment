package com.lucasengcomp.challengepayment.application.dto.order;

import com.lucasengcomp.challengepayment.domain.entities.Item;
import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class InsertOrderDTO {

    private Long id;

    private BigDecimal total;

    private BigDecimal totalToPay;

    private PaymentMethod paymentMethod;

    private Deliver deliver;

    private Long personId;

    private List<Item> items;
}
