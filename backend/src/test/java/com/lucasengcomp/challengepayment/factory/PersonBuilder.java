package com.lucasengcomp.challengepayment.factory;

import com.lucasengcomp.challengepayment.application.dto.enums.PaymentMethodDTO;
import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonBuilder {

    private static final int DEFAULT_SCALE = 2;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static Person createPersonValid() {
        return new Person(
                1L,
                "Freddie Mercury",
                "000.111.222.33",
                null,
                null,
                null,
                null
        );
    }

    public static UpdatePersonDTO updatePersonValid() {
        return new UpdatePersonDTO(
                "Roger Taylor",
                "111.222.222.33"
        );
    }

    public static Person createPersonCPFInvalid() {
        return new Person(
                2L,
                "Freddie Mercury",
                "12.345.678.99",
                null,
                null,
                null,
                null
        );
    }

    public static List<InsertPersonDTO> createPeopleListItem() {
        List<InsertPersonDTO> peopleList = new ArrayList<>();

        List<InsertItemDTO> itemsForPerson1 = Arrays.asList(
                new InsertItemDTO(1L, "Item 1", BigDecimal.valueOf(10.0).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE)),
                new InsertItemDTO(2L, "Item 2", BigDecimal.valueOf(15.0).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE))
        );

        InsertPersonDTO person1 = new InsertPersonDTO(1L, "João", "123.456.789-00", BigDecimal.ZERO,
                BigDecimal.ZERO, PaymentMethodDTO.PIX, itemsForPerson1);

        List<InsertItemDTO> itemsForPerson2 = Collections.singletonList(
                new InsertItemDTO(3L, "Item 3", BigDecimal.valueOf(8.0).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE))
        );

        InsertPersonDTO person2 = new InsertPersonDTO(2L, "Maria", "987.654.321-00",
                BigDecimal.ZERO, BigDecimal.ZERO, PaymentMethodDTO.CARD, itemsForPerson2);

        peopleList.add(person1);
        peopleList.add(person2);

        return peopleList;
    }
}
