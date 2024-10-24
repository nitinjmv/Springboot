package dev.jmv.controller;

import dev.jmv.dto.Product;
import dev.jmv.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> retrieve() {
        return ResponseEntity.ok(productService.retrieve());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> retrieveById(@PathVariable long id) {
        return productService.retrieveById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }
}
