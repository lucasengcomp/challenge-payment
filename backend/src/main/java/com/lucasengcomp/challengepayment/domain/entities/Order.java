package com.lucasengcomp.challengepayment.domain.entities;

import com.lucasengcomp.challengepayment.domain.entities.embededs.Deliver;
import com.lucasengcomp.challengepayment.domain.enums.PaymentMethod;
import jakarta.persistence.*;
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

    @Column(nullable = false, name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(nullable = false, name = "total_to_pay")
    private BigDecimal totalToPay;

    @Column(name = "person_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> people;

    private BigDecimal total;

    @Embedded
    private Deliver deliver;
}
