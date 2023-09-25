package com.lucasengcomp.challengepayment.application.dto.person;


import com.lucasengcomp.challengepayment.application.dto.enums.PaymentMethodDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
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
public class PersonDTO {

    private Long id;

    private String name;

    private String cpf;

    private BigDecimal total;

    private BigDecimal totalToPay;

    private PaymentMethodDTO paymentMethod;

    private List<ItemDTO> items;
}
