package com.lucasengcomp.challengepayment.application.util;

import lombok.Getter;

@Getter
public class Messages {

    public static final String ENTITY_NOT_FOUND = "Entidade não encontrada para o registro: ";
    public static final String ENTITY_DOES_NOT_EXISTS = "Entidade não existe ou foi excluída";

    protected Messages() {
    }
}
