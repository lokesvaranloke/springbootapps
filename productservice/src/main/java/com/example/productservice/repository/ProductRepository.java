package com.example.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.productservice.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
