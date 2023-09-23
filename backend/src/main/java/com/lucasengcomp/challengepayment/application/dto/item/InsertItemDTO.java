package com.lucasengcomp.challengepayment.application.dto.item;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class InsertItemDTO {

    private Long id;

    private String description;

    private BigDecimal price;
}
