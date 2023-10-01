package com.lucasengcomp.challengepayment.application.services.impl;


import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.SimplePersonDTO;
import com.lucasengcomp.challengepayment.application.mappers.PersonMapper;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_NOT_FOUND;
import static com.lucasengcomp.challengepayment.factory.PersonBuilder.createPersonValid;
import static com.lucasengcomp.challengepayment.factory.PersonBuilder.updatePersonValid;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl service;

    @Autowired
    private PersonMapper mapper;

    private Long existingId = 1L;
    private Long nonExistingId = 1000L;

    @Test
    @DisplayName("Should attempt to update a person and return a custom exception")
    void updateExistingPerson2() {
        ResourceNotFoundException result = assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingId, updatePersonValid());
        });
        assertEquals(result.getMessage(), ENTITY_NOT_FOUND + nonExistingId);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existing Person")
    void deleteNonExistingItem() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.deleteResource(nonExistingId);
        });
    }

    @Test
    @DisplayName("Should delete an existing Person")
    void deleteExistingItem() {
        assertDoesNotThrow(() -> {
            service.deleteResource(existingId);
        });
    }

    @Test
    @DisplayName("Should insert a new Person")
    void insertPersonValid() {
        InsertPersonDTO insertPersonDTO = mapper.convertEntityToInsert(createPersonValid());
        SimplePersonDTO personInserted = service.insert(insertPersonDTO);

        assertNotNull(personInserted);
        assertNotNull(personInserted.getId());
        assertEquals(personInserted.getName(), insertPersonDTO.getName());
    }

    @Test
    @DisplayName("Should return Person paged")
    void findAllPaged() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Tony Stark", result.getContent().get(0).getName());
        Assertions.assertEquals("Harry Potter", result.getContent().get(1).getName());
        Assertions.assertEquals("Alvo Percival Wulfrico Brian Dumbledore", result.getContent().get(2).getName());
        Assertions.assertEquals("Jack Sparrow", result.getContent().get(3).getName());
    }

    @Test
    @DisplayName("Should return 3 people per page")
    void findAllPaged_With3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 4);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Tony Stark", result.getContent().get(0).getName());
        Assertions.assertEquals("111.222.333-44", result.getContent().get(0).getCpf());

        Assertions.assertEquals("Harry Potter", result.getContent().get(1).getName());
        Assertions.assertEquals("222.333.444-55", result.getContent().get(1).getCpf());

        Assertions.assertEquals("Alvo Percival Wulfrico Brian Dumbledore", result.getContent().get(2).getName());
        Assertions.assertEquals("444.333.222-11", result.getContent().get(2).getCpf());

        Assertions.assertEquals("Jack Sparrow", result.getContent().get(3).getName());
        Assertions.assertEquals("888.555.333-11", result.getContent().get(3).getCpf());
    }

    @Test
    @DisplayName("Should return all people per page verify size")
    void findAllPaged_ShouldReturn3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.getNumber());
        Assertions.assertEquals(20, result.getSize());
        Assertions.assertEquals(4, result.getTotalElements());
    }

    @Test
    @DisplayName("Should return page empty when page does not exist")
    void findAllPaged_ShouldReturnEmptyPageWhenPageDoesNotExist() {
        PageRequest pageRequest = PageRequest.of(50, 10);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should search Person by id and verify fields")
    void findById_verifyFields() {
        PersonDTO personById = service.findById(existingId);

        Assertions.assertNotNull(personById);
        Assertions.assertEquals(1, personById.getId());
        Assertions.assertEquals("Tony Stark", personById.getName());
    }

    @Test
    @DisplayName("Should throws exception ResourceNotFoundException when search inexistingId")
    void findById_whenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }
}
