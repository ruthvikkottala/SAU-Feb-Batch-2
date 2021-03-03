package com.re.auhibernate2;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String category_name;
	public int getCategory_id() {
		return id;
	}

	
	public void setCategory_id(int category_id) {
		this.id = category_id;
	}
	@OneToMany
	private List<Product>products=new ArrayList<Product>();
	public int getId() {
		return id;
	}
	@ManyToMany(mappedBy="categories")
	private List<Supplier> suppliers=new ArrayList<Supplier>();


	public List<Supplier> getSuppliers() {
		return suppliers;
	}


	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
