package com.transactionmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionmanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	public Order save(Order order);
}
