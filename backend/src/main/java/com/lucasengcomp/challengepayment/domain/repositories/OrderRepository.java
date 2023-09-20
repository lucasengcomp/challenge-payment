package com.lucasengcomp.challengepayment.domain.repositories;

import com.lucasengcomp.challengepayment.application.dto.OrderDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepository {
    Page<OrderDTO> findPageable(Pageable pageable);

    OrderDTO findById(Long id);

    InsertOrderDTO insert(InsertOrderDTO dto);
}
