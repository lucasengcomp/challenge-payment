package com.lucasengcomp.challengepayment.application.controllers;


import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import com.lucasengcomp.challengepayment.application.services.ItemServiceIT;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private ItemServiceIT service;

    @GetMapping
    public ResponseEntity<Page<ItemDTO>> findPaged(Pageable pageable) {
        Page<ItemDTO> items = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(items);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemDTO> findById(@PathVariable Long id) {
        ItemDTO item = service.findById(id);
        return ResponseEntity.ok().body(item);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> insert(@RequestBody InsertItemDTO dto) {
        ItemDTO itemDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(itemDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateItemDTO> update(@PathVariable Long id, @RequestBody UpdateItemDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteResource(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Registro excluído com sucesso!");
    }
}
