package com.lucasengcomp.challengepayment.factory;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.Person;

import java.math.BigDecimal;

public class PersonBuilder {


    public static Person createPersonValid() {
        return new Person(
                1L,
                "Freddie Mercury",
                new BigDecimal(10.00),
                new BigDecimal(13.00)
        );
    }

    public static PersonDTO createPersonDTOValid() {
        return new PersonDTO(
                1L,
                "Freddie Mercury",
                new BigDecimal(10.00),
                new BigDecimal(13.00)
        );
    }

}
