package com.lucasengcomp.challengepayment.domain.exceptions.controller.messages;

public class MessagesExceptions {

    public static final String DATABASE_EXCEPTION = "Exceção de banco de dados";

    public static final String ERROR_ARGUMENT_EXCEPTION = "Exceção nos argumentos passados";

    public static final String ERROR_INTEGRITY_DATA_EXCEPTION = "Exceção na integridade de dados. Verifique o preenchimento do(s) campo(s): ";

    public static final String UNKNOWN_FIELD = "Campo não conhecido ";

    public static final String ENTITY_DOES_NOT_EXISTS = "Entidade inexistente";

    public static final String ERROR_UNPROCESABLE_ENTITY = "Entidade não processada pois há erros nos campos";

    public static final String UNPROCESABLE_ENTITY = "Entidade não processada";

    public static final String RESOURCE_NOT_FOUND = "Recurso não encontrado";

    protected MessagesExceptions() {
    }
}
