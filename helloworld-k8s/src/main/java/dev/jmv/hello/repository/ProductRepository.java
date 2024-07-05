package dev.jmv.hello.repository;

import dev.jmv.hello.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
