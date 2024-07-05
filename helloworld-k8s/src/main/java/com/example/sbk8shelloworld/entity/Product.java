package com.example.sbk8shelloworld.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;
}
