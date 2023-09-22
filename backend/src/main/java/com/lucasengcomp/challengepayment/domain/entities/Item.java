package com.lucasengcomp.challengepayment.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_item", schema = "sc_divideai")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal price;
}
