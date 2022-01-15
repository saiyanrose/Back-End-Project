package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="assignsc")
@Table(name="assignsc")
public class assignsc {

	@Id
	@Column(name="rollno")
	private int rollno;
	
	@Column(name="std_name")
	private String name;
	
	@Column(name="std_age")
	private int age;
	
	@Column(name ="std_class" )
	private String classname;
	
	public assignsc() {
		
	}
	
	

	public assignsc(int rollno, String name, int age, String classname) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.classname = classname;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "assignsc [rollno=" + rollno + ", name=" + name + ", age=" + age + ", classname=" + classname + "]";
	}
	
	
}
