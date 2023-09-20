package com.lucasengcomp.challengepayment.application.services.impl;


import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl service;

    private Long existingId;
    private Long nonExistingId;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        nonExistingId = 1000L;
    }

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
    void findAllPagedWith3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<PersonDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Joel Victor", result.getContent().get(0).getName());
        Assertions.assertEquals("Eli Alves", result.getContent().get(1).getName());
        Assertions.assertEquals("Lucas Galvao", result.getContent().get(2).getName());
    }
}
