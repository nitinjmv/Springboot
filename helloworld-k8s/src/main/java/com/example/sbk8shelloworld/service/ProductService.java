package com.example.sbk8shelloworld.service;

import com.example.sbk8shelloworld.entity.Product;
import com.example.sbk8shelloworld.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
