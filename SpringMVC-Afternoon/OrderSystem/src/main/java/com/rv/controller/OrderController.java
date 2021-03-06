package com.rv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rv.model.Orders;
import com.rv.repository.OrderRepository;
import com.rv.service.ItemService;
import com.rv.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService order;
	
	
	@GetMapping("/orders")
	public List<Orders> getOrders(){
		return order.getOrders();
	}
	
	@PostMapping("/orders")
	public Orders createOrder(@RequestBody Orders o) {
		return order.createOrder(o);
	}
	
	
	
}
