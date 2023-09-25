package com.lucasengcomp.challengepayment.application.util.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {})
@Size(min = 14, max = 14, message = "O CPF deve conter 11 dígitos")
@Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$", message = "O CPF deve estar no formato 123.456.789-01")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface CPF {
    String message() default "O CPF informado é inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
