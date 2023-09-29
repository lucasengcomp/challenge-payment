package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.SimplePersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import com.lucasengcomp.challengepayment.application.services.PersonServiceIT;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.lucasengcomp.challengepayment.application.util.Messages.REMOVED_SUCESSFULL;

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

    @PostMapping
    public ResponseEntity<SimplePersonDTO> insert(@Valid @RequestBody InsertPersonDTO dto) {
        SimplePersonDTO personDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(personDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatePersonDTO> update(@PathVariable Long id, @Valid @RequestBody UpdatePersonDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteResource(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(REMOVED_SUCESSFULL);
    }
}
