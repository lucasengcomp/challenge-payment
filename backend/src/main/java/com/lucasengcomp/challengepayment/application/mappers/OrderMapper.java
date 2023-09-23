package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.OrderDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;
import com.lucasengcomp.challengepayment.domain.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO convertToOrderDTO(Order entity);

    InsertOrderDTO convertToInsertDTO(Order entity);

    Order convertToOrder(InsertOrderDTO dto);
}
