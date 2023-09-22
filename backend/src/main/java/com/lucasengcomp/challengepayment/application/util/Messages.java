package com.lucasengcomp.challengepayment.application.util;

import lombok.Getter;

@Getter
public class Messages {

    public static final String ENTITY_NOT_FOUND = "Não existe este registro: ";

    public static final String ENTITY_DOES_NOT_EXISTS = "Entidade não existe ou foi excluída";

    public static final String INTEGRITY_VIOLATION = "Não é possível excluir o registro devido a integridade de dados";

    public static final String DATABASE_EXCEPTION = "Database Exception";

    protected Messages() {
    }
}
