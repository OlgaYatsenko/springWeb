package com.coffee.shop;

import com.coffee.shop.data.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ShopApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ProductRepository repository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repository.save(new Product("ESSP", "Esspresso", Product.Type.DRINK));
				repository.save(new Product("WHCO", "White Coffee", Product.Type.DRINK));
				repository.save(new Product("TIRA", "Tiramisu", Product.Type.DESSERT));
				repository.save(new Product("CHMO", "Chocolate mousse", Product.Type.DESSERT));
			}
		};
	}
}