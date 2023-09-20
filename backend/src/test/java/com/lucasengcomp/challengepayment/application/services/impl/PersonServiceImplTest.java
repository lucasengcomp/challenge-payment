package com.lucasengcomp.challengepayment.application.services.impl;


import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Transactional
@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl service;

    private Long existingId = 1L;
    private Long nonExistingId = 1000L;


    @Test
    @DisplayName("Should return Person paged")
    void findAllPaged() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Joel Victor", result.getContent().get(0).getName());
        Assertions.assertEquals("Eli Alves", result.getContent().get(1).getName());
        Assertions.assertEquals("Lucas Galvao", result.getContent().get(2).getName());
        Assertions.assertEquals("Matheus Carvalho", result.getContent().get(3).getName());
    }

    @Test
    @DisplayName("Should return 3 people per page")
    void findAllPaged_With3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Joel Victor", result.getContent().get(0).getName());
        Assertions.assertEquals("Eli Alves", result.getContent().get(1).getName());
        Assertions.assertEquals("Lucas Galvao", result.getContent().get(2).getName());
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
        Assertions.assertEquals("Joel Victor", personById.getName());
        Assertions.assertEquals(new BigDecimal("100.00"),
                personById.getOrderValue().setScale(2, RoundingMode.HALF_UP));
        Assertions.assertEquals(new BigDecimal("90.00"),
                personById.getTotalToPay().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Should throws exception ResourceNotFoundException when search inexistingId")
    void findById_whenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }
}
