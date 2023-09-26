package com.lucasengcomp.challengepayment.application.dto.item;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsertItemDTO {

    private Long id;

    private String description;

    private BigDecimal price;
}
