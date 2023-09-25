package com.lucasengcomp.challengepayment.application.dto.enums;

import lombok.Getter;

@Getter
public enum TypeMealDTO {

    RESTAURANT(1, "Restaurante"),
    DELIVER(2, "Entrega");

    private final int position;
    private final String description;

    TypeMealDTO(int position, String description) {
        this.position = position;
        this.description = description;
    }
}
