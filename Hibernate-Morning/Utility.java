package com.rv.auhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Utility {
	public static Session getSession() {
		Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
	    SessionFactory sf=con.buildSessionFactory();
	    Session session=sf.openSession();
	   return session;
	}
	
}
