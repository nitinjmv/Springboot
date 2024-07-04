package com.example.sbswagger.service;

import com.example.sbswagger.entity.Product;
import com.example.sbswagger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }
}
