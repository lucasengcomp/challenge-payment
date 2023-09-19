package com.lucasengcomp.challengepayment.persistence.impl;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.application.mappers.PersonMapper;
import com.lucasengcomp.challengepayment.domain.entities.Person;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import com.lucasengcomp.challengepayment.domain.repositories.PersonRepository;
import com.lucasengcomp.challengepayment.persistence.interfaces.JpaPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_NOT_FOUND;


@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private PersonMapper mapper;
    private JpaPersonRepository jpaPersonRepository;

    @Override
    public Page<PersonDTO> findPageable(Pageable pageable) {
        Page<Person> personPage = jpaPersonRepository.findAll(pageable);
        return personPage.map(mapper::convertToPersonDTO);
    }

    @Override
    public PersonDTO findById(Long id) {
        return getPersonById(id);
    }

    private PersonDTO getPersonById(Long id) throws ResourceNotFoundException {
        Person foundPerson  = jpaPersonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
        return mapper.convertToPersonDTO(foundPerson);
    }
}

