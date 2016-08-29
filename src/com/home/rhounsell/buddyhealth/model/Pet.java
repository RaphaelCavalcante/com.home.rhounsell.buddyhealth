package com.home.rhounsell.buddyhealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private Integer age;
	
	public Pet(){}
	public Pet(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
