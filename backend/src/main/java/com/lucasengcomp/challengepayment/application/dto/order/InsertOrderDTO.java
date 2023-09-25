package com.lucasengcomp.challengepayment.application.dto.order;

import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.enums.TypeMeal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertOrderDTO {

    private Long id;

    private BigDecimal total;

    private BigDecimal totalToPay;

    private Deliver deliver;

    private TypeMealDTO typeMeal;

    private List<InsertPersonDTO> people;
}
