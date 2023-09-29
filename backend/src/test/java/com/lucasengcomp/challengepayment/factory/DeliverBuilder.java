package com.lucasengcomp.challengepayment.factory;

import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lucasengcomp.challengepayment.application.util.BigDecimalConstants.DEFAULT_SCALE_2;

public class DeliverBuilder {

    private static final int DEFAULT_SCALE = 2;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static Deliver createDeliver() {
        Deliver deliver = new Deliver();
        deliver.setTax(BigDecimal.valueOf(8.00).setScale(DEFAULT_SCALE_2, DEFAULT_ROUNDING_MODE));
        deliver.setDiscount(BigDecimal.valueOf(12.00).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE));
        return deliver;
    }
}
