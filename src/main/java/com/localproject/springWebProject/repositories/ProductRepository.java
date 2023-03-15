package com.localproject.springWebProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localproject.springWebProject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
