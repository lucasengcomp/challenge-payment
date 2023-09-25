package com.lucasengcomp.challengepayment.domain.entities;

import com.lucasengcomp.challengepayment.application.util.annotations.CPF;
import com.lucasengcomp.challengepayment.domain.enums.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_person", schema = "sc_divideai")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100, message = "O campo deve conter de 2 a 50 caracteres")
    private String name;

    @CPF
    private String cpf;

    @PositiveOrZero(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal totalToPay;

    @PositiveOrZero(message = "O valor deve ser positivo ou zero")
    @Digits(integer = 6, fraction = 2, message = "O número deve ter no máximo {integer} dígitos inteiros e {fraction} casas decimais")
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> items;
}
