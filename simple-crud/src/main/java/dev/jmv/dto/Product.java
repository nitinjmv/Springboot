package dev.jmv.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {

    private long id;
    private String name;
    private double price;
}
