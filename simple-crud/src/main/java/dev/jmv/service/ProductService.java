package dev.jmv.service;

import dev.jmv.ProductInventory;
import dev.jmv.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductInventory productInventory;
    public List<Product> retrieve() {
        return productInventory.getProducts();
    }

    public Product create(Product product) {
        return productInventory.addProduct(product);
    }

    public Optional<Product> retrieveById(long id) {
        return productInventory.getProductById(id);
    }
}
