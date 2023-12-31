package com.lucasengcomp.challengepayment.domain.entities;

import com.lucasengcomp.challengepayment.application.dto.enums.TypeMealDTO;
import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_order", schema = "sc_divideai")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal total;

    @Positive(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal totalToPay;

    @Positive(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal percentageFeeWaiter;

    @Enumerated(EnumType.STRING)
    private TypeMealDTO typeMeal;

    @Embedded
    private Deliver deliver;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> people;
}
