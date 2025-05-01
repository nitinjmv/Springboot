package dev.jmv.sevices.ProductService;

import dev.jmv.dto.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    private List<Product> productList;

    @PostConstruct
    public void loadProducts() {
        productList = IntStream.rangeClosed(1, 1000)
                .mapToObj(i -> Product.builder()
                        .id(i)
                        .name("product-" + i)
                        .price(new Random().nextDouble(i))
                        .build()
                ).collect(Collectors.toList());
    }
    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product with id "+ id + " Not found."));
    }
}
