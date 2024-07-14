package dev.jmv.mappings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "CART")
public class Cart extends BaseEntityAudit {

    private List<String> items;

    @OneToOne(mappedBy = "cart")
    private Users user;
}
