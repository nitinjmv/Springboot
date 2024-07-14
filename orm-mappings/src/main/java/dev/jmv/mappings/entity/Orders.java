package dev.jmv.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Order;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Orders extends BaseEntityAudit {

    private String orderReference;

    private OrderStatus orderStatus;

    // Without mappedBy: there will be extra columns in both the tables for foreign key.
    // mappedBy is the name of the variable defined in the other table. then only ORDER_DETAILS will have an extra column "ORDER_ID"
    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    // One User can place Many Orders
    @ManyToOne
    private Users user;
}
