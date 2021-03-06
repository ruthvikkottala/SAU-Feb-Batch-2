package com.rv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rv.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>  {
	Integer deleteById(int id);
}
