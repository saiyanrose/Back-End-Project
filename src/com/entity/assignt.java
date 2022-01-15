package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="assignt")
@Table(name="assignt")
public class assignt {
	
	@Id
	@Column(name="teacher_id")
	private int id;
	
	@Column(name="teacher_name")
	private String name;
	
	@Column(name="subject_name")
	private String subname;
	
	@Column(name="class_name")
	private String classname;
	
	public assignt() {
		
	}

	public assignt(int id, String name, String subname, String classname) {
		super();
		this.id = id;
		this.name = name;
		this.subname = subname;
		this.classname = classname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "assignt [id=" + id + ", name=" + name + ", subname=" + subname + ", classname=" + classname + "]";
	}

	
}
