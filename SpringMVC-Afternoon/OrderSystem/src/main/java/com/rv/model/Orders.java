package com.rv.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	@OneToMany(targetEntity = OrderItem.class,cascade = CascadeType.ALL)
	@JoinColumn(name="orderId",referencedColumnName = "order_id")
	private List<OrderItem> items;
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", items=" + items + "]";
	}


}
