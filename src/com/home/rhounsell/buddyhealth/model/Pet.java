package com.home.rhounsell.buddyhealth.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pet implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5110096789700423819L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private Integer age;
	private Set <Medicine> medicineRegistry = new HashSet <Medicine>(0);
	private Set <History> historyRegistry = new HashSet <History> (0);
	
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
	public Set <Medicine> getMedicineRecord(){
		return this.medicineRegistry;
	}
	public void setMedicineRecord(HashSet <Medicine> medicineRegistry){
		this.medicineRegistry= medicineRegistry;
	}
	public Set <History> getPetHistory(){
		return this.historyRegistry;
	}
	public void setPetHistory(HashSet <History> historyRegistry){
		this.historyRegistry = historyRegistry;
	}
}