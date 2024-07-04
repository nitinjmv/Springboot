package com.example.sbswagger.controller;

import com.example.sbswagger.entity.Product;
import com.example.sbswagger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        Optional<Product> product = productService.getProduct(id);
        return product.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
}
