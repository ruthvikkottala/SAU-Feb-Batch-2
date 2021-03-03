package com.rv.auhibernate4;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure().addAnnotatedClass(Batch.class).addAnnotatedClass(Students.class);
	    SessionFactory sf=con.buildSessionFactory();
	    Session s1=sf.openSession();
		
		
		Transaction tx1 = s1.beginTransaction();
		Batch b1 = new Batch();
		b1.setBatchid(100);
		b1.setDuration("4 months");
		b1.setFees(10000);

		Batch b2 = new Batch();
		b2.setBatchid(101);
		b2.setDuration("6 months");
		b2.setFees(15000);

		Students st1 = new Students();
		st1.setStudentid(111);
		st1.setFname("abc");
		st1.setLname("cb");
		st1.setAge(23);

		Students st2 = new Students();
		st2.setStudentid(112);
		st2.setFname("aaa");
		st2.setLname("ddd");
		st2.setAge(45);

		Students st3 = new Students();
		st3.setStudentid(113);
		st3.setFname("kkk");
		st3.setLname("llll");
		st3.setAge(33);

		Students st4 = new Students();
		st4.setStudentid(114);
		st4.setFname("sss");
		st4.setLname("rrrr");
		st4.setAge(44);
		
		b1.getStudents().add(st1);
		b1.getStudents().add(st2);
		b1.getStudents().add(st3);
		b1.getStudents().add(st4);
		
		b2.getStudents().add(st1);
		b2.getStudents().add(st2);
		b2.getStudents().add(st3);
		b2.getStudents().add(st4);
		
		s1.save(b1);
		s1.save(b2);
		
		s1.save(st1);
		s1.save(st2);
		s1.save(st3);
		s1.save(st4);
		
		tx1.commit();
		
		
		System.out.println("done");

	}

}
