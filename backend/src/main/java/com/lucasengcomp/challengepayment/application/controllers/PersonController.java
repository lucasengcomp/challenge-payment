package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.application.services.interfaces.PersonServiceIT;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
public class PersonController {

    private PersonServiceIT service;

    @GetMapping
    public ResponseEntity<Page<PersonDTO>> findPaged(Pageable pageable) {
        Page<PersonDTO> allPleople = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(allPleople);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        PersonDTO person = service.findById(id);
        return ResponseEntity.ok().body(person);
    }
}
