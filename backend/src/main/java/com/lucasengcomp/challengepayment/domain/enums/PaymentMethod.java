package com.lucasengcomp.challengepayment.domain.enums;


import lombok.Getter;

@Getter
public enum PaymentMethod {

    PIX(1, "Pix"),
    CARD(2, "Cartão"),
    MONEY(3, "Dinheiro");

    private final int position;
    private final String description;

    PaymentMethod(int position, String description) {
        this.position = position;
        this.description = description;
    }
}
