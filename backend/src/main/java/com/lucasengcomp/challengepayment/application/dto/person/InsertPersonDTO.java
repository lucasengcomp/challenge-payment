package com.lucasengcomp.challengepayment.application.dto.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InsertPersonDTO {

    private Long id;

    private String name;

    private String cpf;
}
