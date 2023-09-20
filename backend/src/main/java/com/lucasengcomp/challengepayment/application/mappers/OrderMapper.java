package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.OrderDTO;
import com.lucasengcomp.challengepayment.domain.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO convertToPersonDTO(Order entity);
}
