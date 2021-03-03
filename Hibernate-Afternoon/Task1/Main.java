package com.re.auhibernate2;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class Main {

	public static void main(String[] args) {
		Session ps=Utility.getSession();
		Transaction tx1=ps.beginTransaction();
		Product p1=new Product();
		p1.setProduct_name("Cooker");
		p1.setPrice(3999);
		ps.save(p1);
		
		Product p2=new Product();
		p2.setProduct_name("Microwave");
		p2.setPrice(5500);
		ps.save(p2);
		
		Product p3=new Product();
		p3.setProduct_name("Basketball");
		p3.setPrice(2999);
		ps.save(p3);
		
		Product p4=new Product();
		p4.setProduct_name("Cricketkit");
		p4.setPrice(5999);
		ps.save(p4);
		
		Product p5=new Product();
		p5.setProduct_name("Steamer");
		p5.setPrice(1999);
		ps.save(p5);
		
		tx1.commit();
		ps.close();
		
		Session cs=Utility.getSession();
		Transaction tx;
		tx=cs.beginTransaction();
		Category c=new Category();
		c.setCategory_name("Household");
		c.getProducts().add(p1);
		c.getProducts().add(p2);
		c.getProducts().add(p5);
		cs.save(c);
		
		
		Category c2=new Category();
		c2.setCategory_name("Sports");
		cs.save(c2);
		c2.getProducts().add(p3);
		c2.getProducts().add(p4);
		tx.commit();
		
		cs.close();
		
		Session ss=Utility.getSession();
		Transaction tx2;
		tx2=ss.beginTransaction();
		Supplier s1=new Supplier();
		s1.setSupplier_name("HomeVendor1");
		s1.getCategories().add(c);
		ss.save(s1);
		Supplier s2=new Supplier();
		s2.setSupplier_name("SportVendor1");
		s2.getCategories().add(c2);
		ss.save(s2);
		Supplier s3=new Supplier();
		s3.setSupplier_name("HomeVendor2");
		s3.getCategories().add(c);
		ss.save(s3);
		
		
		
		tx2.commit();
		
		
		

	}

}
