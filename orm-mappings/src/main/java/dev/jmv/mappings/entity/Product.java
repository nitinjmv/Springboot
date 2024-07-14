package dev.jmv.mappings.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Product extends BaseEntity {

    private String title;

    private Double price;

    // Many products can be part of Many Categories
    // Just by adding @ManytoMany in both entity classes would create two following extra mapping tables. So there will be four tables in total.
    // PRODUCT_CATEGORIES
    // CATEGORY_PRODUCTS

    // PRODUCT_CATEGORIES mapping table would be created. with mappedBy "PRODUCT_CATEGORIES" will not get created
    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

}
