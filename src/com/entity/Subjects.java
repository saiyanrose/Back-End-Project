package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="subjects")
@Table(name="subjects")
public class Subjects {
	
	@Id
	@Column(name="subject_id")
	private int id;
	
	@Column(name="subject_name")
	private String name;
		
	
	public Subjects(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Subjects(String name) {
		super();
		this.name = name;
	}

	public Subjects() {
		
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
		return "Subjects [id=" + id + ", name=" + name + "]";
	}
	
	

}
