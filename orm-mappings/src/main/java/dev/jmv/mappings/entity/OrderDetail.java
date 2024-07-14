package dev.jmv.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail extends BaseEntityAudit {

    private String orderNumber;

    @OneToOne
    private Orders order;
}
