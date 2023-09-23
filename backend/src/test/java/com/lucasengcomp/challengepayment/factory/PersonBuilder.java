package com.lucasengcomp.challengepayment.factory;

import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.Person;

import java.util.ArrayList;

public class PersonBuilder {


    public static Person createPersonValid() {
        return new Person(
                1L,
                "Freddie Mercury",
                "000.111.222.33",
                null,
                null,
                new ArrayList<>()
        );
    }

    public static PersonDTO createPersonDTOValid() {
        return new PersonDTO(
                1L,
                "Freddie Mercury",
                "012.345.678.99",
                new ArrayList<>()
        );
    }
}
