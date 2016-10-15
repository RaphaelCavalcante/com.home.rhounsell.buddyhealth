package com.home.rhounsell.buddyhealth.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="pet", catalog="buddyhealth")
public class Pet implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer petId;
	
	private String name;
	private Integer age;
	private Date birthDate;
	private String breed;
	private String species;
	private Owner owner;
	
	private Set<Medicine> medicines = new HashSet<Medicine>(0);
	
	public Pet(){}
	public Pet(String name, Integer age){
		this.name = name;
		this.age = age;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pet_id", nullable=false, unique=true)
	public Integer getId(){
		return this.petId;
	}
	public void setId(Integer id){
		this.petId=id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date",nullable=false)
	public Date getBirthDate(){
		return this.birthDate;
	}
	public void setBirthDate(Date birthDate){
		this.birthDate=birthDate;
	}
	
	@Column(name="breed",nullable=false)
	public String getBreed(){
		return this.breed;
	}
	public void setBreed(String breed){
		this.breed=breed;
	}
	
	@Column(name="species", nullable=false)
	public String getSpecies(){
		return this.species;
	}
	public void setSpecies(String species){
		this.species=species;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id",nullable=false)
	public Owner getOwner(){
		return this.owner;
	}
	public void setOwner(Owner owner){
		this.owner=owner;
	}
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="pet_medicine", catalog="buddyhealth",
	joinColumns={
			@JoinColumn(name="pet_id", nullable=false)},
	inverseJoinColumns= {
			@JoinColumn (name="medicine_id", nullable=false)
	})
	public Set<Medicine> getPetMedicines(){
		return this.medicines;
	}
	public void setPetMedicines(Set<Medicine> medicine){
		this.medicines =medicine;
	}
}