package com.rv3.auhibernate3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main {

	public static void main(String[] args) {
		Configuration con=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Project.class);
	    SessionFactory sf=con.buildSessionFactory();
	    Session session=sf.openSession();
	    Transaction tx=session.beginTransaction();
	    Project p1=new Project();
	    p1.setP_name("IronFarm");
	    
	    Project p2=new Project();
	    p2.setP_name("GoldFarm");
	    
	    Project p3=new Project();
	    p3.setP_name("SlimeFarm");
	    
	    Student s1=new Student();
	    s1.setName("Rohan");
	    s1.setProject(p1);
	    session.save(s1);
	    Student s2=new Student();
	    s2.setName("Diya");
	    s2.setProject(p2);
	    session.save(s2);
	    Student s3=new Student();
	    s3.setName("Pooja");
	    s3.setProject(p1);
	    session.save(s3);
	    Student s4=new Student();
	    s4.setName("Akhil");
	    s4.setProject(p2);
	    session.save(s4);
	    Student s5=new Student();
	    s5.setName("Anuj");
	    s5.setProject(p3);
	    session.save(s5);
	    Student s6=new Student();
	    s6.setName("Ashish");
	    s6.setProject(p3);
	    session.save(s6);
	    
	    
//	    p1.getStudents().add(s1);
//	    p1.getStudents().add(s3);
	    session.save(p1);
	    
	    
//	    p2.getStudents().add(s2);
//	    p2.getStudents().add(s4);
	    session.save(p2);
	    
	    
//	    p3.getStudents().add(s6);
//	    p3.getStudents().add(s5);
	    session.save(p3);
	    
	    tx.commit();

	}

}
