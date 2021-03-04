package com.au.app;

import java.io.Serializable;

public class Product implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;
	
	private String name;
	private int price;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id+"::"+name+"::"+price;
	}
}
