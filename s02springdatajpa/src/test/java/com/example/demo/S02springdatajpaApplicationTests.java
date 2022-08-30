package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
class S02springdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void saveProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		Product product = new Product();
		product.setName("headset");
		product.setDescription("Bluetooth");
		product.setPrice(2500);
		
		repo.save(product);
	}
	
	@Test
	void readProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		Optional<Product> optionalProduct = repo.findById(1);
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			System.out.println(product);
		}
	}
	
	@Test
	void updateProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		Optional<Product> optionalProduct = repo.findById(1);
		Product product = null;
		if(optionalProduct.isPresent()) {
			product = optionalProduct.get();
			System.out.println(product);
		}
		if(product!=null) {
			product.setPrice(3300.0);
			product.setDescription("Normal Wood");
			repo.save(product);
			System.out.println("After change");
			System.out.println(product);
		}
	}
	
	@Test
	void deleteProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		repo.deleteById(4);
		repo.deleteById(5);	
	}
	
	@Test
	void findByName() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		List<Product> products = repo.findByName("table");
		System.out.println(products);
	}
	
	@Test
	void findByPrice() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		List<Product> products = repo.findByPrice(2500.0);
		System.out.println(products);
	}
	
	@Test
	void findByNameAndPrice() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		List<Product> products = repo.findByNameAndPrice("sofa", 4500.0);
		System.out.println(products);
	}

}
