package com.lucasengcomp.challengepayment.application.dto.item;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UpdateItemDTO {

    private String description;

    private BigDecimal price;
}
