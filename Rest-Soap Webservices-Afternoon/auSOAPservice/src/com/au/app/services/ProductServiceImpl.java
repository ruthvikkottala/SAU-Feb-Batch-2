package com.au.app.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.au.app.Product;

public class ProductServiceImpl implements ProductService {
	private static Map<Integer,Product> productList = new HashMap<Integer,Product>();
	
	@Override
	public boolean addProduct(Product p) {
		if(productList.get(p.getId()) != null) return false;
		productList.put(p.getId(), p);
		return true;
	}

	@Override
	public boolean deleteProduct(int id) {
		if(productList.get(id) == null) return false;
		productList.remove(id);
		return true;
	}

	@Override
	public Product getProduct(int id) {
		return productList.get(id);
	}

	@Override
	public Product[] getAllProducts() {
		Set<Integer> ids = productList.keySet();
		Product[] p = new Product[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = productList.get(id);
			i++;
		}
		return p;
	}

}
