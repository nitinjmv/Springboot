package dev.jmv.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Payment extends BaseEntityAudit {

    private PaymentMode paymentMode;

    private double amount;

    @OneToOne
    private Orders order;

    @ManyToOne
    private Users user;

}
