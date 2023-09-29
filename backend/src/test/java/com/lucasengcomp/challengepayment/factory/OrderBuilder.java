package com.lucasengcomp.challengepayment.factory;

import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OrderBuilder {

    private static final int DEFAULT_SCALE = 2;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static InsertOrderDeliverDTO createOrderDeliverDTO(List<InsertPersonDTO> peopleList, Deliver deliver) {
        return new InsertOrderDeliverDTO(
                1L,
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.valueOf(10.00).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE),
                deliver,
                TypeMealDTO.RESTAURANT,
                peopleList
        );
    }
}
