package com.lucasengcomp.challengepayment.domain.entities.embededs;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Embeddable
public class Deliver implements Serializable {
    private static final long serialVersionUID = 1L;

    @PositiveOrZero(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal tax;

    @PositiveOrZero(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal discount;
}
