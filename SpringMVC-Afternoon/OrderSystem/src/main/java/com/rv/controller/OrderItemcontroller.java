package com.rv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rv.model.Item;
import com.rv.model.OrderItem;
import com.rv.service.OrderItemService;



@RestController
public class OrderItemcontroller {
	@Autowired
	OrderItemService orderitem;
	
	@GetMapping("/item")
	public List<OrderItem> getItems(@RequestParam("id") int id){
		return orderitem.getItems(id);
	}
	
	@PostMapping("/additem")
	public String addItem(@RequestParam("id") int id,@RequestBody OrderItem i) {
		return orderitem.addItem(id,i);
	}
	
	@PutMapping("/updateItem")
	public String updateItem(@RequestParam("id") int id,@RequestParam("orderid") int orderid,@RequestBody OrderItem i) {
		return orderitem.updateItem(id,orderid,i);
	}
	
	@RequestMapping(value = "/deleteItem",method=RequestMethod.DELETE)
	public String deleteItem(@RequestParam("id") int id) {
		return orderitem.deleteItem(id);
	}
}
