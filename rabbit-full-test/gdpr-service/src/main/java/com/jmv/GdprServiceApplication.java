package com.jmv;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GdprServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdprServiceApplication.class, args);
	}

}
