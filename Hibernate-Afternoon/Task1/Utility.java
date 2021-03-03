package com.re.auhibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Utility {
	public static Session getSession() {
		Configuration con=new Configuration().configure().addAnnotatedClass(Category.class).addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class);
	    SessionFactory sf=con.buildSessionFactory();
	    Session session=sf.openSession();
	   return session;
	}
	
	
}
