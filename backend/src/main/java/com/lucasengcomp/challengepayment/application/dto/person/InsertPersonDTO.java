package com.lucasengcomp.challengepayment.application.dto.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucasengcomp.challengepayment.application.dto.enums.PaymentMethodDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsertPersonDTO {

    private Long id;

    private String name;

    private String cpf;

    private BigDecimal totalPayment;

    private PaymentMethodDTO paymentMethod;

    private List<ItemDTO> items;
}
