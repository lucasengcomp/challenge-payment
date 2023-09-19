package com.lucasengcomp.challengepayment.persistence.impl;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.application.mappers.PersonMapper;
import com.lucasengcomp.challengepayment.domain.entities.Person;
import com.lucasengcomp.challengepayment.domain.repositories.PersonRepository;
import com.lucasengcomp.challengepayment.persistence.interfaces.JpaPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private PersonMapper mapper;
    private JpaPersonRepository jpaPersonRepository;

    @Override
    public Page<PersonDTO> findPageable(Pageable pageable) {
        Page<Person> personPage = jpaPersonRepository.findAll(pageable);
        return personPage.map(mapper::convertToPerson);
    }
}
