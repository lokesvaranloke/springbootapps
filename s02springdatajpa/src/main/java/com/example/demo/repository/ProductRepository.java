package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	//to give custom methods findByName here this Name should be same as in Product class but small change 
	//there it will be as name but when giving here it should be Name i.e. firstletter should be caps
	//and we give only methods not implementation..
	List<Product> findByName(String name);
	
	List<Product> findByPrice(Double Price);
	
	List<Product> findByNameAndPrice(String name, Double Price);
}
