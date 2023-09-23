package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import com.lucasengcomp.challengepayment.application.services.ItemServiceIT;
import com.lucasengcomp.challengepayment.domain.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemServiceIT {

    private ItemRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<ItemDTO> findAllPaged(Pageable pageable) {
        return repository.findPageable(pageable);
    }

    @Override
    public ItemDTO findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ItemDTO insert(InsertItemDTO dto) {
        return repository.insert(dto);
    }

    @Override
    public UpdateItemDTO update(Long id, UpdateItemDTO dto) {
        return repository.update(id, dto);
    }

    @Override
    public void deleteResource(Long id) {
        repository.deleteResource(id);
    }
}
