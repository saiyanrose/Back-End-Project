package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="class")
@Table(name="class")
public class listofclass {

	@Id
	@Column(name="class_id")
	private int id;
	
	@Column(name="class_name")
	private String name;

	
	public listofclass(int id) {
		
		this.id = id;
	}

	public listofclass() {
		
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

	public listofclass(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "listofclass [id=" + id + ", name=" + name + "]";
	}
	
}
