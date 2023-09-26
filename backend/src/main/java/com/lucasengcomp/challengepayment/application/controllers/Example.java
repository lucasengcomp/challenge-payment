package com.lucasengcomp.challengepayment.application.controllers;

import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderRestaurantDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/porcentagem")
public class Example {

    private static final int DEFAULT_SCALE_2 = 2;

    @PostMapping
    public ResponseEntity<InsertOrderRestaurantDTO> insert(@RequestBody InsertOrderRestaurantDTO dto) {
        calculateOrderDetails(dto);
        return ResponseEntity.ok().body(dto);
    }

    private void calculateOrderDetails(InsertOrderRestaurantDTO dto) {
        BigDecimal totalOrderValue = calculateTotalOrderValue(dto);

        if (totalOrderValue != null) {
            BigDecimal totalWaiterFee = calculateTotalWaiterFee(dto.getPeople(), totalOrderValue, dto.getPercentageFeeWaiter());
            dto.setTotal(totalOrderValue.setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP));
            dto.setTotalToPay(totalOrderValue.add(totalWaiterFee).setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP));

            for (InsertPersonDTO person : dto.getPeople()) {
                BigDecimal personTotalValue = calculatePersonValue(person);
                BigDecimal personWaiterFee = calculatePersonWaiterFee(totalWaiterFee, personTotalValue, totalOrderValue);
                BigDecimal totalToPay = calculateTotalToPay(personTotalValue, personWaiterFee);

                person.setTotal(personTotalValue.setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP));
                person.setTotalToPay(totalToPay.setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP));
            }
        }
    }

    private BigDecimal calculateTotalOrderValue(InsertOrderRestaurantDTO dto) {
        BigDecimal totalValue = BigDecimal.ZERO;
        List<InsertPersonDTO> people = dto.getPeople();
        for (InsertPersonDTO person : people) {
            for (ItemDTO item : person.getItems()) {
                totalValue = totalValue.add(item.getPrice());
            }
        }
        return totalValue;
    }

    private BigDecimal calculatePersonValue(InsertPersonDTO person) {
        return person.getItems().stream()
                .map(ItemDTO::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculatePersonWaiterFee(BigDecimal totalWaiterFee, BigDecimal personTotalValue, BigDecimal totalOrderValue) {
        BigDecimal personPercentage = personTotalValue.divide(totalOrderValue, DEFAULT_SCALE_2, RoundingMode.HALF_UP);
        return totalWaiterFee.multiply(personPercentage);
    }

    private BigDecimal calculateTotalToPay(BigDecimal personTotalValue, BigDecimal personWaiterFee) {
        return personTotalValue.add(personWaiterFee);
    }

    private BigDecimal calculateTotalWaiterFee(List<InsertPersonDTO> people, BigDecimal totalOrderValue, BigDecimal percentageFeeWaiter) {
        BigDecimal totalWaiterFee = BigDecimal.ZERO;
        for (InsertPersonDTO person : people) {
            BigDecimal personTotalValue = calculatePersonValue(person);
            BigDecimal personPercentage = personTotalValue.divide(totalOrderValue, DEFAULT_SCALE_2, RoundingMode.HALF_UP);
            BigDecimal personWaiterFee = totalOrderValue.multiply(percentageFeeWaiter.divide(BigDecimal.valueOf(100))).multiply(personPercentage);
            totalWaiterFee = totalWaiterFee.add(personWaiterFee);
        }
        return totalWaiterFee;
    }
}