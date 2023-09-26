package com.lucasengcomp.challengepayment.persistence.impl;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.application.mappers.OrderMapper;
import com.lucasengcomp.challengepayment.domain.entities.Order;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import com.lucasengcomp.challengepayment.domain.repositories.OrderRepository;
import com.lucasengcomp.challengepayment.persistence.interfaces.JpaOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_NOT_FOUND;


@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private JpaOrderRepository jpaOrderRepository;
    private OrderMapper mapper;

    @Override
    public Page<OrderDTO> findPageable(Pageable pageable) {
        Page<Order> personPage = jpaOrderRepository.findAll(pageable);
        return personPage.map(mapper::convertToOrderDTO);
    }

    @Override
    public OrderDTO findById(Long id) {
        return getOrderById(id);
    }

    @Override
    public InsertOrderDeliverDTO insert(InsertOrderDeliverDTO dto) {
        Order newOrder = mapper.convertToOrder(dto);
        newOrder = jpaOrderRepository.save(newOrder);
        return mapper.convertToInsertDTO(newOrder);
    }

    private OrderDTO getOrderById(Long id) throws ResourceNotFoundException {
        Order order = jpaOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
        return mapper.convertToOrderDTO(order);
    }
}
