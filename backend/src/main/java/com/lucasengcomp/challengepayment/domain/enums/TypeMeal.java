package com.lucasengcomp.challengepayment.domain.enums;

import lombok.Getter;

@Getter
public enum TypeMeal {

    RESTAURANT(1, "Restaurante"),
    DELIVER(2, "Entrega");

    private final int position;
    private final String description;

    TypeMeal(int position, String description) {
        this.position = position;
        this.description = description;
    }
}
