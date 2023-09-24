package com.lucasengcomp.challengepayment.application.dto.enums;

public enum PaymentMethodDTO {

    PIX(1, "Pix"),
    CARD(2, "Cartão"),
    MONEY(3, "Dinheiro");

    private final int position;
    private final String description;

    PaymentMethodDTO(int position, String description) {
        this.position = position;
        this.description = description;
    }
}
