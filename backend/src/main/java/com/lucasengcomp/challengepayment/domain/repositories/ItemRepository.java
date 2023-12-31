package com.lucasengcomp.challengepayment.domain.repositories;

import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepository {

    Page<ItemDTO> findPageable(Pageable pageable);

    ItemDTO findById(Long id);

    ItemDTO insert(InsertItemDTO dto);

    UpdateItemDTO update(Long id, UpdateItemDTO dto);

    void deleteResource(Long id);
}
