package com.lucasengcomp.challengepayment.application.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsertOrderRestaurantDTO {

    private Long id;

    private BigDecimal total;

    private BigDecimal totalToPay;

    private BigDecimal percentageFeeWaiter;

    private TypeMealDTO typeMeal;

    private List<InsertPersonDTO> people;
}
