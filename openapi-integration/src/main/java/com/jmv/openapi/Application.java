package com.jmv.openapi;

import com.jmv.openapi.entity.Product;
import com.jmv.openapi.repository.ProductRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@OpenAPIDefinition
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Product laptop = Product.builder()
                .title("Laptop")
                .price(2321.3)
                .build();

        Product mobile = Product.builder()
                .title("mobile")
                .price(231.3)
                .build();

        Product tab = Product.builder()
                .title("Tab")
                .price(1000.32)
                .build();

        productRepository.saveAll(Arrays.asList(laptop, mobile, tab));

    }

}
