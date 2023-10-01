package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.SimplePersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import com.lucasengcomp.challengepayment.application.services.PersonServiceIT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.lucasengcomp.challengepayment.application.util.Messages.*;

@RestController
@AllArgsConstructor
@Tag(name = "Pessoas")
@RequestMapping("/people")
public class PersonController {

    private PersonServiceIT service;

    @GetMapping
    @Operation(summary = "Busca todas as Pessoas paginadas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = PersonDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Page<PersonDTO>> findPaged(Pageable pageable) {
        Page<PersonDTO> allPeople = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(allPeople);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca uma Pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = PersonDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        PersonDTO person = service.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping
    @Operation(summary = "Insere uma nova Pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = SimplePersonDTO.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = INVALID_REQUISITION),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<SimplePersonDTO> insert(@Valid @RequestBody InsertPersonDTO dto) {
        SimplePersonDTO personDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(personDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma Pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = UpdatePersonDTO.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = INVALID_REQUISITION),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<UpdatePersonDTO> update(@PathVariable Long id, @Valid @RequestBody UpdatePersonDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma Pessoa por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = REMOVED_SUCESSFULL),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteResource(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(REMOVED_SUCESSFULL);
    }
}
