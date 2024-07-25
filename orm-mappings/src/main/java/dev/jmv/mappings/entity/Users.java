package dev.jmv.mappings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "USERS")
public class Users extends BaseEntityAudit {

    private String name;

    // One User has One Cart at a time
    // If mappedBy is provided here, reference column (USER_ID) will get created in CART table.
    @OneToOne
    private Cart cart;

    // One User can place Many Orders
    // Have to provide mappedBy here then USER_ID column will get created in ORDERS table.
    // ManyToOne doesn't support mappedBy
    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    // Many payments can be made by One User
    // Have to provide mappedBy here then USER_ID column will get created in PAYMENT table.
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;
}
