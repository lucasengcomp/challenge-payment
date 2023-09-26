package com.lucasengcomp.challengepayment.domain.calculations.impl;

import com.lucasengcomp.challengepayment.application.dto.item.ItemDTO;
import com.lucasengcomp.challengepayment.application.dto.order.InsertOrderDeliverDTO;
import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.domain.calculations.RestaurantCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.lucasengcomp.challengepayment.application.util.BigDecimalConstants.DEFAULT_SCALE_2;

@Component
public class RestaurantPaymentCalculationStrategy implements RestaurantCalculationStrategy {


    @Override
    public void calculateOrderDetails(InsertOrderDeliverDTO dto) {
        BigDecimal totalOrderValue = calculateTotalOrderValue(dto);
        BigDecimal totalWaiterFee = calculateTotalWaiterFee(dto.getPeople(), totalOrderValue, dto.getPercentageFeeWaiter());

        BigDecimal totalToPayForOrder = totalOrderValue.add(totalWaiterFee).setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP);

        for (InsertPersonDTO person : dto.getPeople()) {
            BigDecimal personTotalValue = calculatePersonValue(person);

            BigDecimal personWaiterFee = totalWaiterFee
                    .multiply(personTotalValue)
                    .divide(totalOrderValue, DEFAULT_SCALE_2, RoundingMode.HALF_UP);

            BigDecimal totalToPayForPerson = personTotalValue.add(personWaiterFee)
                    .setScale(DEFAULT_SCALE_2, RoundingMode.HALF_UP);

            person.setTotal(personTotalValue);
            person.setTotalToPay(totalToPayForPerson);

            dto.setTotal(totalOrderValue);
            dto.setTotalToPay(totalToPayForOrder);
        }
    }

    private BigDecimal calculateTotalOrderValue(InsertOrderDeliverDTO dto) {
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
