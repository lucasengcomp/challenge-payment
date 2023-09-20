package com.lucasengcomp.challengepayment.application.dto.person;

import com.lucasengcomp.challengepayment.domain.enums.TypeMeal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InsertPersonDTO {

    private Long id;

    private String name;

    private BigDecimal orderValue;

    private BigDecimal totalToPay;

    private BigDecimal additionalTax;

    private TypeMeal typeMeal;
}
