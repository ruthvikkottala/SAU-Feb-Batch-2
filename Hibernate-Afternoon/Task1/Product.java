package com.re.auhibernate2;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String product_name;
	
	private int price;
	
	

	public int getProdcut_id() {
		return id;
	}

	public void setProdcut_id(int prodcut_id) {
		this.id = prodcut_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Product [prodcut_id=" + id + ", product_name=" + product_name + ", price=" + price;
	}

	
	
	

}
