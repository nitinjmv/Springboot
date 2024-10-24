package dev.jmv;


import dev.jmv.dto.Product;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductInventory {

    List<Product> products = new ArrayList<>();

    public Product addProduct(Product product){
        this.products.add(product);
        return product;
    }

    public List<Product> getProducts(){
        return products;
    }


    public Optional<Product> getProductById(long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
