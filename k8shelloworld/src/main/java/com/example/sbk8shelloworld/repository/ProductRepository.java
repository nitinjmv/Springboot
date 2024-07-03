package com.example.sbk8shelloworld.repository;

import com.example.sbk8shelloworld.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
