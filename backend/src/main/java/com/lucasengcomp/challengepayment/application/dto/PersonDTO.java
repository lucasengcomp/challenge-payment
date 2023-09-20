package com.lucasengcomp.challengepayment.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    private String name;

    private BigDecimal orderValue;

    private BigDecimal totalToPay;
}
