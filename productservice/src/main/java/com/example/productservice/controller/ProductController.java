package com.example.productservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Product;
import com.example.productservice.exception.ProductNotFoundException;
import com.example.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	@GetMapping
	public Iterable<Product> getProducts(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getOneProduct(@PathVariable("id") Integer id) {
		Optional<Product> optProduct = repo.findById(id);
		if(optProduct.isEmpty()) {
			throw new ProductNotFoundException(id);
		}
		return optProduct.get();
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
