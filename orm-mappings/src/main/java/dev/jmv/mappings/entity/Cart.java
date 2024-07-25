package dev.jmv.mappings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CART")
public class Cart extends BaseEntityAudit {

    private List<String> items;

    @OneToOne(mappedBy = "cart")
    private Users user;
}
