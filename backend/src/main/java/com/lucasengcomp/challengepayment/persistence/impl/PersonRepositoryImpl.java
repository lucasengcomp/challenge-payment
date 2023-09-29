package com.lucasengcomp.challengepayment.persistence.impl;

import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.SimplePersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import com.lucasengcomp.challengepayment.application.mappers.PersonMapper;
import com.lucasengcomp.challengepayment.domain.entities.Person;
import com.lucasengcomp.challengepayment.domain.exceptions.service.DataBaseException;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import com.lucasengcomp.challengepayment.domain.repositories.PersonRepository;
import com.lucasengcomp.challengepayment.persistence.interfaces.JpaPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_NOT_FOUND;
import static com.lucasengcomp.challengepayment.application.util.Messages.INTEGRITY_VIOLATION;


@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private PersonMapper mapper;
    private JpaPersonRepository jpaPersonRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<PersonDTO> findPageable(Pageable pageable) {
        Page<Person> personPage = jpaPersonRepository.findAll(pageable);
        return personPage.map(mapper::convertToPersonDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        return getPersonById(id);
    }

    @Override
    public SimplePersonDTO insert(InsertPersonDTO dto) {
        Person person = mapper.convertInsertToEntity(dto);
        jpaPersonRepository.save(person);
        return mapper.convertToSimplePersonDTO(person);
    }

    @Override
    @Transactional
    public UpdatePersonDTO update(Long id, UpdatePersonDTO dto) {

        Optional<Person> idFound = jpaPersonRepository.findById(id);

        if (idFound.isPresent()) {
            Person entity = idFound.get();
            mapper.convertUpdateToEntity(dto, entity);
            entity = jpaPersonRepository.save(entity);

            return mapper.convertEntityToUpdate(entity);
        }
        throw new ResourceNotFoundException(ENTITY_NOT_FOUND + id);
    }

    @Override
    public void deleteResource(Long id) {
        try {
            getPersonById(id);
            jpaPersonRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(INTEGRITY_VIOLATION);
        }
    }

    private PersonDTO getPersonById(Long id) throws ResourceNotFoundException {
        Person foundPerson = jpaPersonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
        return mapper.convertToPersonDTO(foundPerson);
    }
}

