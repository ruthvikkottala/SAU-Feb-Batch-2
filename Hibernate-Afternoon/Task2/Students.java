package com.rv.auhibernate4;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Students {
	@Id
	private int studentid;
	private String fname;
	private String lname;
	private int age;
	@ManyToMany(mappedBy="students")
	private Set<Batch> batches = new HashSet<Batch>();
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Batch> getBatches() {
		return batches;
	}
	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	

}
