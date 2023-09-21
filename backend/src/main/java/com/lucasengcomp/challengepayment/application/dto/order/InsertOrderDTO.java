package com.lucasengcomp.challengepayment.application.dto.order;

import com.lucasengcomp.challengepayment.domain.entities.Person;
import com.lucasengcomp.challengepayment.domain.enums.TypeMeal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class InsertOrderDTO {

    private Long id;

    private BigDecimal totalValueOrder;

    private BigDecimal totalToPay;

    private BigDecimal taxRate;

    private BigDecimal incrementRate;

    private TypeMeal typeMeal;

    private List<Person> people;

}
