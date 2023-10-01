package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.application.services.OrderServiceIT;
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
@Tag(name = "Pedidos")
@RequestMapping("/orders")
public class OrderController {

    private OrderServiceIT service;

    @GetMapping
    @Operation(summary = "Busca todos os Pedidos paginados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = OrderDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<Page<OrderDTO>> findPaged(Pageable pageable) {
        Page<OrderDTO> allOrders = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(allOrders);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um Pedido por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = OrderDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping
    @Operation(summary = "Insere um novo Pedido")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = InsertOrderDeliverDTO.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = INVALID_REQUISITION),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<InsertOrderDeliverDTO> insert(@Valid @RequestBody InsertOrderDeliverDTO dto) {
        InsertOrderDeliverDTO inserted = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(inserted);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um Pedido por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = REMOVED_SUCESSFULL),
            @ApiResponse(responseCode = "404", description = ENTITY_DOES_NOT_EXISTS),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteResource(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(REMOVED_SUCESSFULL);
    }
}
