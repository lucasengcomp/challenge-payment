package com.lucasengcomp.challengepayment.application.mappers;


import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.domain.entities.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO convertToOrderDTO(Order entity);

    InsertOrderDeliverDTO convertToInsertDTO(Order entity);

    Order convertToOrder(InsertOrderDeliverDTO dto);
}
