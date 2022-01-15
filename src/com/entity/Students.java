package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="students")
@Table(name="students")
public class Students {

	@Id
	@Column(name="roll_no")
	private int rollno;
	
	@Column(name="std_name")
	private String name;
	
	@Column(name="std_age")
	private String age; 
	
	public Students() {
		
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Students [rollno=" + rollno + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
