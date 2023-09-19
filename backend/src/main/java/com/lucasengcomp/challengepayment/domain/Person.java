package com.lucasengcomp.challengepayment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tbl_person")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 50, message = "O campo deve conter de 2 a 50 caracteres")
    private String name;

    @Column(nullable = false)
    private BigDecimal orderValue;

    private BigDecimal totalToPay;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
