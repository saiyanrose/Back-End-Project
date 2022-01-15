package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="assigncs")
@Table(name = "assigncs")
public class assigncs {

	@Id
	@Column(name="class_id")
	private int id;
	
	@Column(name="sub_name")
	private String name;
	
	
	
	public assigncs(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public assigncs() {
		
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

	@Override
	public String toString() {
		return "assigncs [id=" + id + ", name=" + name + "]";
	}
	
	
}
