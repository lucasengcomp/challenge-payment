package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.application.services.impl.PersonServiceImpl;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import com.lucasengcomp.challengepayment.factory.PersonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonServiceImpl service;

    private PersonDTO personDTO;
    private Long existingId = 1L;
    private Long nonExistingId = 1000L;

    private static final String ENDPOINT = "/people";

    @BeforeEach
    void setUp() {
        personDTO = PersonBuilder.createPersonDTOValid();
    }

    @Test
    @DisplayName("Find should return page")
    void findAll_ShouldReturnPage() throws Exception {
        ResultActions result = mockMvc
                .perform(get(ENDPOINT)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }

    @Test
    void findById_ShouldReturnPersonWhenIdExists() throws Exception {
        when(service.findById(existingId)).thenReturn(personDTO);

        ResultActions result = mockMvc.perform(get(ENDPOINT + "/{id}", existingId)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.orderValue").exists());
        result.andExpect(jsonPath("$.totalToPay").exists());
    }

    @Test
    void findById_ShouldReturnNotFoundWhenIdDoesNotExists() throws Exception {
        when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);

        ResultActions result = mockMvc.perform(get(ENDPOINT + "/{id}", nonExistingId)
                .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isNotFound());
    }
}
