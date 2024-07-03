package com.example.k8sbpostgres;

import com.example.k8sbpostgres.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class K8sbpostgresApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(K8sbpostgresApplication.class, args);
    }

    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.findAll().forEach(System.out::println);
    }
}
