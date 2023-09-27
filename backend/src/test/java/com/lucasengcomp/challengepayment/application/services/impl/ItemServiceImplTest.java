package com.lucasengcomp.challengepayment.application.services.impl;


import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.item.UpdateItemDTO;
import com.lucasengcomp.challengepayment.domain.exceptions.service.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lucasengcomp.challengepayment.application.util.BigDecimalConstants.DEFAULT_SCALE_2;
import static com.lucasengcomp.challengepayment.application.util.Messages.ENTITY_NOT_FOUND;
import static com.lucasengcomp.challengepayment.factory.ItemBuilder.createItemValid;
import static com.lucasengcomp.challengepayment.factory.ItemBuilder.updateValidItem;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl service;

    private final Long existingId = 1L;
    private final Long nonExistingId = 1000L;

    @Test
    @DisplayName("Should throw exception when updating non-existing item")
    void updateNonExistingItemVerifyMessageReturned() {
        UpdateItemDTO updatedItemDTO = updateValidItem();

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingId, updatedItemDTO);
        });

        assertEquals(ENTITY_NOT_FOUND + nonExistingId, exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when updating non-existing item")
    void updateNonExistingItem() {
        UpdateItemDTO updatedItemDTO = updateValidItem();

        assertThrows(ResourceNotFoundException.class, () -> {
            service.update(nonExistingId, updatedItemDTO);
        });
    }

    @Test
    @DisplayName("Should update an existing item")
    void updateExistingItem_() {
        UpdateItemDTO updatedItemDTO = updateValidItem();

        UpdateItemDTO updatedItem = service.update(existingId, updatedItemDTO);

        assertNotNull(updatedItem);
        assertEquals(updatedItemDTO.getDescription(), updatedItem.getDescription());
        assertEquals(updatedItemDTO.getPrice().setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP),
                updatedItem.getPrice().setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Should update an existing item")
    void updateExistingItem() {
        UpdateItemDTO updatedItemDTO = updateValidItem();
        UpdateItemDTO updatedItem = service.update(existingId, updatedItemDTO);

        assertNotNull(updatedItem);
        assertEquals(updatedItemDTO.getDescription(), updatedItem.getDescription());
        assertEquals(updatedItemDTO.getPrice().setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP),
                updatedItem.getPrice().setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP));
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existing item")
    void deleteNonExistingItem() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.deleteResource(nonExistingId);
        });
    }

    @Test
    @DisplayName("Should delete an existing item")
    void deleteExistingItem() {
        assertDoesNotThrow(() -> {
            service.deleteResource(existingId);
        });
    }

    @Test
    @DisplayName("Should insert a new item")
    void insertItemValid() {
        ItemDTO insertedItem = service.insert(createItemValid());

        String description = createItemValid().getDescription();
        BigDecimal price = createItemValid().getPrice();

        assertNotNull(insertedItem);
        assertNotNull(insertedItem.getId());
        assertEquals(description, insertedItem.getDescription());
        assertEquals(price, insertedItem.getPrice());
    }

    @Test
    @DisplayName("Should return Item paged")
    void findAllPaged() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<ItemDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        assertItem(result.getContent().get(0), "Hamburger", BigDecimal.valueOf(42.00));
        assertItem(result.getContent().get(1), "Refrigerante", BigDecimal.valueOf(8.00));
        assertItem(result.getContent().get(2), "Batata", BigDecimal.valueOf(15.99));
        assertItem(result.getContent().get(3), "Combo casal", BigDecimal.valueOf(69.99));
        assertItem(result.getContent().get(4), "Barca de sanduiche", BigDecimal.valueOf(75.00));
        assertItem(result.getContent().get(5), "Kebab", BigDecimal.valueOf(21.00));
        assertItem(result.getContent().get(6), "Shawarma", BigDecimal.valueOf(18.00));
        assertItem(result.getContent().get(7), "Nachos", BigDecimal.valueOf(25.99));
        assertItem(result.getContent().get(8), "Ravioli", BigDecimal.valueOf(35.79));
        assertItem(result.getContent().get(9), "Arancino", BigDecimal.valueOf(23.99));
        assertItem(result.getContent().get(10), "Brownie", BigDecimal.valueOf(12.00));
        assertItem(result.getContent().get(11), "Açaí", BigDecimal.valueOf(29.99));
        assertItem(result.getContent().get(12), "Camarão", BigDecimal.valueOf(36.79));
        assertItem(result.getContent().get(13), "Peixe frito", BigDecimal.valueOf(49.99));
    }

    @Test
    @DisplayName("Should return 10 items per page")
    void findAllPaged_With3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<ItemDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        assertEquals(10, result.getNumberOfElements());
        assertItem(result.getContent().get(0), "Hamburger", BigDecimal.valueOf(42.00));
        assertItem(result.getContent().get(1), "Refrigerante", BigDecimal.valueOf(8.00));
        assertItem(result.getContent().get(2), "Batata", BigDecimal.valueOf(15.99));
        assertItem(result.getContent().get(3), "Combo casal", BigDecimal.valueOf(69.99));
        assertItem(result.getContent().get(4), "Barca de sanduiche", BigDecimal.valueOf(75.00));
        assertItem(result.getContent().get(5), "Kebab", BigDecimal.valueOf(21.00));
        assertItem(result.getContent().get(6), "Shawarma", BigDecimal.valueOf(18.00));
        assertItem(result.getContent().get(7), "Nachos", BigDecimal.valueOf(25.99));
        assertItem(result.getContent().get(8), "Ravioli", BigDecimal.valueOf(35.79));
        assertItem(result.getContent().get(9), "Arancino", BigDecimal.valueOf(23.99));
    }

    @Test
    @DisplayName("Should return all people per page verify size")
    void findAllPaged_ShouldReturn3PeoplePerPage() {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<ItemDTO> result = service.findAllPaged(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        assertEquals(0, result.getNumber());
        assertEquals(20, result.getSize());
        assertEquals(14, result.getTotalElements());
    }

    @Test
    @DisplayName("Should return page empty when page does not exist")
    void findAllPaged_ShouldReturnEmptyPageWhenPageDoesNotExist() {
        PageRequest pageRequest = PageRequest.of(50, 10);
        Page<ItemDTO> result = service.findAllPaged(pageRequest);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should search Item by id and verify fields")
    void findById_verifyFields() {
        ItemDTO personById = service.findById(existingId);

        Assertions.assertNotNull(personById);
        assertEquals(1, personById.getId());
        Assertions.assertEquals("Hamburger", personById.getDescription());
        Assertions.assertEquals(BigDecimal.valueOf(42.00).setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP), personById.getPrice());
    }

    @Test
    @DisplayName("Should throws exception ResourceNotFoundException when search inexistingId")
    void findById_whenIdDoesNotExist() {
        assertThrows(ResourceNotFoundException.class, () -> {
            service.findById(nonExistingId);
        });
    }

    private void assertItem(ItemDTO item, String expectedDescription, BigDecimal expectedPrice) {
        assertEquals(expectedDescription, item.getDescription());
        assertEquals(expectedPrice.setScale(2, RoundingMode.HALF_UP), item.getPrice().setScale(2, RoundingMode.HALF_UP));
    }
}
