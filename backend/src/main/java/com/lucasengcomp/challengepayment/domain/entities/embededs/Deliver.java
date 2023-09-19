package com.lucasengcomp.challengepayment.domain.entities.embededs;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Embeddable
public class Deliver implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal tax;

    private BigDecimal discount;
}
