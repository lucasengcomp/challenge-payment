package com.lucasengcomp.challengepayment.application.dto.person;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplePersonDTO {

    private Long id;

    private String name;

    private String cpf;
}
