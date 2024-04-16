package com.fragaria.fragariaStoreApi;

import com.fragaria.fragariaStoreApi.entity.Product;
import com.fragaria.fragariaStoreApi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FragariaStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FragariaStoreApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductRepository productRepository) {
		return args -> {
			List<Product> products = Arrays.asList(
					new Product("uva", "morada", 12.3, 5),
					new Product("manzana", "roja", 5.3, 6),
					new Product("pera", "verde", 6.3, 9),
					new Product("banano", "amarillo", 7.2, 5),
					new Product("fresa", "roja", 4.1, 5)
			);
			productRepository.saveAll(products);
		};
	}
}
