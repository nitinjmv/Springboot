package dev.jmv.mappings;

import dev.jmv.mappings.entity.Cart;
import dev.jmv.mappings.entity.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Users user = new Users();
//
//		Cart cart = new Cart();
//		cart.setItems(List.of("Laptop", "Mobile", "Watch"));
//		cart.setUser(user);
//
//		user.setCart();
//

	}
}
