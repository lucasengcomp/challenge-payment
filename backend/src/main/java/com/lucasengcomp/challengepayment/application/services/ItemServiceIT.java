package com.lucasengcomp.challengepayment.application.services;

import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemServiceIT {

    Page<ItemDTO> findAllPaged(Pageable pageable);

    ItemDTO findById(Long id);

    ItemDTO insert(InsertItemDTO dto);

    UpdateItemDTO update(Long id, UpdateItemDTO dto);

    void deleteResource(Long id);
}
