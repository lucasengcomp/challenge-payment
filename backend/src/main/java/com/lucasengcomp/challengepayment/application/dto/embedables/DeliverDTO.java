package com.lucasengcomp.challengepayment.application.dto.embedables;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DeliverDTO {

    private BigDecimal tax;

    private BigDecimal discount;
}
