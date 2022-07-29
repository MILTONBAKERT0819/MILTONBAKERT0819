package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(length = 255,nullable = false)
	private String name;
	
	@Column(nullable = true)
	private Integer preference;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(long id, String name, Integer preference) {
		super();
		this.id = id;
		this.name = name;
		this.preference = preference;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPreference() {
		return preference;
	}

	public void setPreference(Integer preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", preference=" + preference + "]";
	}
	
	

}
