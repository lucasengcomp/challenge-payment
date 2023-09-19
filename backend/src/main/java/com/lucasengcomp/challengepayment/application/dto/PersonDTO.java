package com.lucasengcomp.challengepayment.application.dto;


import com.lucasengcomp.challengepayment.domain.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    private String name;

    private BigDecimal orderValue;

    private BigDecimal totalToPay;

    private Order order;
}
