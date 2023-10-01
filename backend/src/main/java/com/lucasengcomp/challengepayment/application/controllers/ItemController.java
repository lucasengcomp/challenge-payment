package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import com.lucasengcomp.challengepayment.application.services.ItemServiceIT;
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
@Tag(name = "Item")
@RequestMapping("/items")
public class ItemController {

    private ItemServiceIT service;

    @GetMapping
    @Operation(summary = "Busca todos os Itens paginados")
    @ApiResponses({@ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = ItemDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Page<ItemDTO>> findPaged(Pageable pageable) {
        Page<ItemDTO> items = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(items);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Item por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ItemDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<ItemDTO> findById(@PathVariable Long id) {
        ItemDTO item = service.findById(id);
        return ResponseEntity.ok().body(item);
    }

    @PostMapping
    @Operation(summary = "Insere um novo Item")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = ItemDTO.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = INVALID_REQUISITION),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<ItemDTO> insert(@Valid @RequestBody InsertItemDTO dto) {
        ItemDTO itemDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(itemDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Item por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = UpdateItemDTO.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = INVALID_REQUISITION),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<UpdateItemDTO> update(@PathVariable Long id, @Valid @RequestBody UpdateItemDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um Item por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = REMOVED_SUCESSFULL),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteResource(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(REMOVED_SUCESSFULL);
    }
}
