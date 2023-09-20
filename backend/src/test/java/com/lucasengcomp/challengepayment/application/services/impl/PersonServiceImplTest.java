package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.domain.repositories.PersonRepository;
import com.lucasengcomp.challengepayment.factory.PersonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonServiceImpl service;

    private PageImpl<PersonDTO> page;
    private PersonDTO person;

    @BeforeEach
    void setUp() {
        person = PersonBuilder.createPersonDTOValid();
        page = new PageImpl<>(List.of(person));

        Mockito.when(repository.findPageable(ArgumentMatchers.any())).thenReturn(page);
    }

    @Test
    @DisplayName("Should retrieve a paged list of Persons")
    void findAllPaged() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<PersonDTO> result = service.findAllPaged(pageable);
        Assertions.assertNotNull(result, "The returned page should not be null");
        Assertions.assertNotNull(result);
        Mockito.verify(repository, Mockito.times(1)).findPageable(pageable);
    }
}