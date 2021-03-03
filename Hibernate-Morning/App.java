package com.rv.auhibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import org.hibernate.Transaction;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		String yn;
		
        do {
        	@SuppressWarnings("resource")
        	Scanner sc=new Scanner(System.in);
        	
        	System.out.println("-------------Menu------------------");
        	System.out.println("1)Create Employee\n2)Udate Employee\n3)Delete Employee\n4)Get All Employee\n5)Get Employee\n6)Exit");
        	int choice=Integer.parseInt(sc.nextLine());
        	switch(choice) {
	        	case 1:create();break;
	        	case 2:update();break;
	        	case 3:delete();break;
	        	case 4:getAll();break;
	        	case 5:getEmp();break;
	        	case 6:return;
	        	default:break;
        	}
        	System.out.println("Do you wish to continue(y/n)");
        	yn=sc.nextLine();
        }while(yn.equalsIgnoreCase("y"));
        System.out.println("Have a Good day.");
        
        
      }
    static void create() {
    	try {
    		@SuppressWarnings("resource")
        	Scanner sc=new Scanner(System.in);
        	Employee emp=new Employee();
        	System.out.println("Enter First Name");
        	emp.setFname(sc.nextLine());
        	System.out.println("Enter Last Name");
        	emp.setLaname(sc.nextLine());
        	System.out.println("Enter age");
        	emp.setAge(sc.nextLine());
        	System.out.println("Enter DOB");
        	emp.setDOB(sc.nextLine());
        	System.out.println("Enter salary");
        	emp.setSalary(Integer.parseInt(sc.nextLine()));
        	System.out.println("Enter Designation");
        	emp.setDesignation(sc.nextLine());
        	Session session=Utility.getSession();
        	Transaction tx=session.beginTransaction();
        	session.save(emp);
        	tx.commit();
        	System.out.println("Employee saved");
    	}
    	catch (Exception e) {
			System.out.println("Enter details correctlt(age must be of length 2)");
		}
    	
    	
    	
    }
	static void update() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String choice;
		System.out.println("Enter 1 to update all employees\nEnter 2 to update specific employee");
		choice=sc.nextLine();
		switch(choice) {
		case "1":updateAll();break;
		case "2":updateById();break;
		default:break;
		}
	    	
	    }
	static void updateAll() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		Session session=Utility.getSession();
    	Transaction tx=session.beginTransaction();
    	List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
    	if(employees.size()==0) {
    		System.out.println("No employees to update");
    		return;
    	}
    	System.out.println("Enter 1 to change First Name\nEnter 2 to change Last Name\nEnter 3 to change age\nEnter 4 to change salary\nEnter 5 to change DOB\nEnter 6 to change Designation");
    	String choice=sc.nextLine();
    	switch(choice) {
    	case "1":	System.out.println("Enter First name");
    				String fname=sc.nextLine();
    				
    				for(Employee emp:employees) {
    					emp.setFname(fname);
    					
    				}
    				System.out.println("Updated");
    				break;
    	case "2":	System.out.println("Enter Last name");
			    	String lname=sc.nextLine();
					for(Employee emp:employees) {
						emp.setLaname(lname);
					}
					System.out.println("Updated");
    				break;
    	case "3":	System.out.println("Enter Age");
			    	String age=sc.nextLine();
					for(Employee emp:employees) {
						emp.setAge(age);
						System.out.println("Updated Age");
					}
					System.out.println("Updated");
    				break;
    	case "4":	System.out.println("Enter Salary");
			    	int salary=Integer.parseInt(sc.nextLine());
					for(Employee emp:employees) {
						emp.setSalary(salary);
					}
					System.out.println("Updated");
    				break;
    	case "5":	System.out.println("Enter DOB");
			    	String dob=sc.nextLine();
					for(Employee emp:employees) {
						emp.setDOB(dob);
					}
					System.out.println("Updated");
    				break;
    	case "6":	System.out.println("Enter Designation");
			    	String des=sc.nextLine();
					for(Employee emp:employees) {
						emp.setDesignation(des);
					}
					System.out.println("Updated");
    				break;
    	default:break;
    	}
    	tx.commit();
		
	}
	
	static void updateById() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=Integer.parseInt(sc.nextLine());
		Session session=Utility.getSession();
    	Transaction tx=session.beginTransaction();
    	Employee emp=session.get(Employee.class, id);
    	if(emp==null) {
    		System.out.println("No employee found.");
    		return;
    	}
    	System.out.println("Enter 1 to change First Name\nEnter 2 to change Last Name\nEnter 3 to change age\nEnter 4 to change salary\nEnter 5 to change DOB\nEnter 6 to change Designation");
    	String choice=sc.nextLine();
    	switch(choice) {
    	case "1":	System.out.println("Enter First name");
    				emp.setFname(sc.nextLine());
    				System.out.println("Updated");
    				break;
    	case "2":	System.out.println("Enter Last name");
    				emp.setLaname(sc.nextLine());
    				System.out.println("Updated");
    				break;
    	case "3":	System.out.println("Enter Age");
    				emp.setAge(sc.nextLine());
    				System.out.println("Updated");
    				break;
    	case "4":	System.out.println("Enter Salary");
    				emp.setSalary(Integer.parseInt(sc.nextLine()));
    				System.out.println("Updated");
    				break;
    	case "5":	System.out.println("Enter DOB");
    				emp.setDOB(sc.nextLine());
    				System.out.println("Updated");
    				break;
    	case "6":	System.out.println("Enter Designation");
    				emp.setDesignation(sc.nextLine());
    				System.out.println("Updated");
    				break;
    	default:break;
    	}
    	tx.commit();
    	
	}
	
	static void delete() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
    	
    	System.out.println("Enter Employee Id");
    	int id=Integer.parseInt(sc.nextLine());
    	Session session=Utility.getSession();
    	Transaction tx=session.beginTransaction();
    	System.out.println("Do you wish to delete (y/n)");
    	String check=sc.nextLine();
    	if(check.equalsIgnoreCase("n")) {
    		System.out.println("Deletion aborted");
    		return;
    	}
    	Employee emp=session.get(Employee.class, id);
    	session.delete(emp);
    	tx.commit();
    	System.out.println(emp+"deleted");
    	
		
	}
	static void getAll() {
		Session session=Utility.getSession();
		List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
		for(Employee emp:employees) {
			System.out.println(emp);
		}
		
	}
	static void getEmp() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
    	Employee emp;
    	System.out.println("Enter Employee Id");
    	int id=Integer.parseInt(sc.nextLine());
    	Session session=Utility.getSession();
    	
    	emp=session.get(Employee.class, id);
    	
    	System.out.println(emp);
    	
		
	}

}
