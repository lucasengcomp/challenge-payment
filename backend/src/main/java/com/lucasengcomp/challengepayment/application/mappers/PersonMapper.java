package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.SimplePersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import com.lucasengcomp.challengepayment.domain.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO convertToPersonDTO(Person entity);
    SimplePersonDTO convertToSimplePersonDTO(Person entity);
    Person convertInsertToEntity(InsertPersonDTO dto);
    Person convertUpdateToEntity(UpdatePersonDTO dto, @MappingTarget Person person);
    UpdatePersonDTO convertEntityToUpdate(Person entity);
    InsertPersonDTO convertEntityToInsert(Person entity);
}
