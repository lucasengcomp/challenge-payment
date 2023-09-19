package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.Person;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO convertToPersonDTO(Person entity);

    Person convertToPerson(Optional<Person> idPerson);
}
