package com.example.sbpostgres.repository;

import com.example.sbpostgres.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
