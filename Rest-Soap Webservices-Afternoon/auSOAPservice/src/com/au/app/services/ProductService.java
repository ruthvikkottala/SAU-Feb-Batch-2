package com.au.app.services;

import com.au.app.Product;

public interface ProductService {
	
	public boolean addProduct(Product p);
	
	public boolean deleteProduct(int id);
	
	public Product getProduct(int id);
	
	public Product[] getAllProducts();
}
