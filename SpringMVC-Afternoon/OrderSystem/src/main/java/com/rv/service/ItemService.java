package com.rv.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rv.model.Item;
import com.rv.model.OrderItem;
import com.rv.model.Orders;
import com.rv.repository.ItemRepository;
import com.rv.repository.OrderRepository;

@Service
public class ItemService {

	
	@Autowired
	ItemRepository irepo;


	public String createItem(int id, Item i) {
		irepo.save(i);
		return "Item created";
	}
	
}
