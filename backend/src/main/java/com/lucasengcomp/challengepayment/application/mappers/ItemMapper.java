package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import com.lucasengcomp.challengepayment.domain.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemDTO convertToPersonDTO(Item entity);

    Item convertToOrder(InsertItemDTO dto);

    Item convertUpdateToEntity(UpdateItemDTO dto, @MappingTarget Item item);

    UpdateItemDTO convertEntityToUpdate(Item entity);
}
