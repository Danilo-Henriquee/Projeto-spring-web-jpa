package com.localproject.springWebProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localproject.springWebProject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
