package com.lucasengcomp.challengepayment.application.dto.item;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsertItemDTO {

    private Long id;

    @Length(min = 3, max = 100, message = "A descrição do item deve conter de 3 a 100 caracteres")
    private String description;

    private BigDecimal price;
}
