package com.rv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rv.model.Orders;
import com.rv.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repo;

	public List<Orders> getOrders() {
		return repo.findAll();
	}

	public Orders createOrder(Orders o) {
		return repo.save(o);
	}
	
	
}
