package com.lucasengcomp.challengepayment.application.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class DeliverDTO {

    private BigDecimal tax;

    private BigDecimal discount;
}
