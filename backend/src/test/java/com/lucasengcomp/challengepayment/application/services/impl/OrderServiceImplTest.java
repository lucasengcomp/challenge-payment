package com.lucasengcomp.challengepayment.application.services.impl;


import com.lucasengcomp.challengepayment.application.dto.embedables.DeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.enums.PaymentMethodDTO;
import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.application.dto.item.InsertItemDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.order.OrderDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.mappers.OrderMapper;
import com.lucasengcomp.challengepayment.application.mappers.PersonMapper;
import com.lucasengcomp.challengepayment.domain.calculations.RestaurantCalculationStrategy;
import com.lucasengcomp.challengepayment.domain.calculations.impl.RestaurantPaymentCalculationStrategy;
import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import com.lucasengcomp.challengepayment.factory.PersonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.lucasengcomp.challengepayment.application.util.BigDecimalConstants.DEFAULT_SCALE_2;
import static com.lucasengcomp.challengepayment.factory.DeliverBuilder.createDeliver;
import static com.lucasengcomp.challengepayment.factory.OrderBuilder.createOrderDeliverDTO;
import static com.lucasengcomp.challengepayment.factory.PersonBuilder.createPeopleListItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@Transactional
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;

    private static final int DEFAULT_SCALE = 2;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    private final Long nonExistingId = 1000L;

    @Mock
    private RestaurantCalculationStrategy calculationStrategy;

    @BeforeEach
    void setUp() {
        calculationStrategy = new RestaurantPaymentCalculationStrategy();
    }

    @Test
    @DisplayName("Calculation of Order Details in Restaurant Payment")
    void calculateOrderDetails_shouldCalculateCorrectTotalValues() {
        List<InsertPersonDTO> peopleList = createPeopleListItem();
        InsertOrderDeliverDTO orderDTO = createOrderDeliverDTO(peopleList, createDeliver());
        calculationStrategy.calculateOrderDetails(orderDTO);

        InsertPersonDTO firstPerson = orderDTO.getPeople().get(0);
        assertEquals(BigDecimal.valueOf(33.00).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), orderDTO.getTotal());
        assertEquals(BigDecimal.valueOf(36.30).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), orderDTO.getTotalToPay());
        assertEquals(BigDecimal.valueOf(25.00).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), firstPerson.getTotal());
        assertEquals(BigDecimal.valueOf(27.50).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE), firstPerson.getTotalToPay());
    }

    @Test
    @DisplayName("Should return Order paged")
    void findAllPaged() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<OrderDTO> result = service.findAllPaged(pageRequest);
        DeliverDTO deliver1 = result.getContent().get(0).getDeliver();

        Assertions.assertFalse(result.isEmpty());
        assertEquals(1, result.getContent().get(0).getId());
        assertEquals(2, result.getContent().get(1).getId());
        assertEquals(BigDecimal.valueOf(5.00).setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP), deliver1.getTax());
        assertEquals(BigDecimal.valueOf(10.00).setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP), deliver1.getDiscount());
        assertEquals(TypeMealDTO.DELIVER, result.getContent().get(0).getTypeMeal());
        assertEquals(TypeMealDTO.RESTAURANT, result.getContent().get(1).getTypeMeal());
    }

    @Test
    @DisplayName("Should return 2 order per page")
    void findAllPaged_With3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<OrderDTO> result = service.findAllPaged(pageRequest);

        assertFalse(result.isEmpty());
        assertFalse(result.getContent().isEmpty());
        assertTrue(result.getContent().size() == 2);
    }

    @Test
    @DisplayName("Should return all orders per page verify size")
    void findAllPaged_ShouldReturn3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<OrderDTO> result = service.findAllPaged(pageRequest);

        assertFalse(result.isEmpty());

        assertEquals(0, result.getNumber());
        assertEquals(20, result.getSize());
        assertEquals(2, result.getTotalElements());
    }

    @Test
    @DisplayName("Should return page empty when page does not exist")
    void findAllPaged_ShouldReturnEmptyPageWhenPageDoesNotExist() {
        PageRequest pageRequest = PageRequest.of(50, 10);
        Page<OrderDTO> result = service.findAllPaged(pageRequest);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should search Order by id and verify fields")
    void findById_verifyFields() {
        Long existingId = 1L;
        OrderDTO orderById = service.findById(existingId);

        Assertions.assertNotNull(orderById);
        assertEquals(existingId, orderById.getId());
        assertEquals(TypeMealDTO.DELIVER, orderById.getTypeMeal());
        assertEquals(BigDecimal.valueOf(248.99), orderById.getTotal());
        assertEquals(null, orderById.getPercentageFeeWaiter());
        assertEquals(BigDecimal.valueOf(243.99), orderById.getTotalToPay());
    }

    @Test
    @DisplayName("Should throws exception ResourceNotFoundException when search inexistingId")
    void findById_whenIdDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }
}
