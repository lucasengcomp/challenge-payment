package com.lucasengcomp.challengepayment.application.dto;

import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.enums.PaymentMethod;
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

    private PaymentMethod paymentMethod;

    private BigDecimal totalToPay;

    private BigDecimal total;

    private Deliver deliver;

    private List<PersonDTO> people;
}
