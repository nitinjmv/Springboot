package dev.jmv.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "CATEGORY")
public class Category extends BaseEntityAudit {

    @ManyToMany // CATEGORIES_PRODUCT mapping table would be created.
    private List<Product> products;

    private String name;


}
