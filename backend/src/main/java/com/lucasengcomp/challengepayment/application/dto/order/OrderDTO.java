package com.lucasengcomp.challengepayment.application.dto.order;

import com.lucasengcomp.challengepayment.application.dto.embedables.DeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private BigDecimal totalToPay;

    private BigDecimal total;

    private BigDecimal percentageFeeWaiter;

    private DeliverDTO deliver;

    private TypeMealDTO typeMeal;

    private List<PersonDTO> people;
}
