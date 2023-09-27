package com.lucasengcomp.challengepayment.factory;

import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;

import java.math.BigDecimal;

public class ItemBuilder {

    public static InsertItemDTO createItemValid() {
        return new InsertItemDTO(
                1L,
                "Lasanha",
                BigDecimal.valueOf(89.00)
        );
    }

    public static InsertItemDTO createInvalidItemDescription() {
        return new InsertItemDTO(
                1L,
                null,
                BigDecimal.valueOf(89.00)
        );
    }

    public static InsertItemDTO createInvalidItemWithPriceZero() {
        return new InsertItemDTO(
                1L,
                "Bolo de cenoura",
                BigDecimal.valueOf(19.99)
        );
    }

    public static UpdateItemDTO updateValidItem() {
        return new UpdateItemDTO(
                "Pão de queijo",
                BigDecimal.valueOf(3.99)
        );
    }

    public static UpdateItemDTO updateInvalidItem() {
        return new UpdateItemDTO(
                null,
                BigDecimal.valueOf(13.99)
        );
    }
}
