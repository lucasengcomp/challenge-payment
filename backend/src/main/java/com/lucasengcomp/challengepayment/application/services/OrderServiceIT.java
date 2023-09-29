package com.lucasengcomp.challengepayment.application.services;

import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderServiceIT {

    Page<OrderDTO> findAllPaged(Pageable pageable);

    OrderDTO findById(Long id);

    InsertOrderDeliverDTO insert(InsertOrderDeliverDTO dto);

    void deleteResource(Long id);
}
