package com.lucasengcomp.challengepayment.persistence.impl;

import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import com.lucasengcomp.challengepayment.application.mappers.ItemMapper;
import com.lucasengcomp.challengepayment.domain.entities.Item;
import com.lucasengcomp.challengepayment.domain.exceptions.service.DataBaseException;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import com.lucasengcomp.challengepayment.domain.repositories.ItemRepository;
import com.lucasengcomp.challengepayment.persistence.interfaces.JpaItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_NOT_FOUND;
import static com.lucasengcomp.challengepayment.application.util.Messages.INTEGRITY_VIOLATION;


@Repository
@AllArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private ItemMapper mapper;
    private JpaItemRepository jpaItemRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ItemDTO> findPageable(Pageable pageable) {
        Page<Item> itemPage = jpaItemRepository.findAll(pageable);
        return itemPage.map(mapper::convertToPersonDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public ItemDTO findById(Long id) {
        return getItemById(id);
    }

    @Override
    public ItemDTO insert(InsertItemDTO dto) {
        Item item = mapper.convertToOrder(dto);
        jpaItemRepository.save(item);
        return mapper.convertToPersonDTO(item);
    }

    @Override
    @Transactional
    public UpdateItemDTO update(Long id, UpdateItemDTO dto) {

        Optional<Item> idFound = jpaItemRepository.findById(id);

        if (idFound.isPresent()) {
            Item entity = idFound.get();
            mapper.convertUpdateToEntity(dto, entity);
            entity = jpaItemRepository.save(entity);

            return mapper.convertEntityToUpdate(entity);
        }
        throw new ResourceNotFoundException(ENTITY_NOT_FOUND + id);
    }

    @Override
    public void deleteResource(Long id) {
        try {
            getItemById(id);
            jpaItemRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(INTEGRITY_VIOLATION);
        }
    }

    private ItemDTO getItemById(Long id) throws ResourceNotFoundException {
        Item foundItem = jpaItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
        return mapper.convertToPersonDTO(foundItem);
    }
}

