package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO convertToPerson(Person entity);
}
