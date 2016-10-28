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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="pet", catalog="buddyhealth")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	private Owner owner_id;
	
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
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id")
	@JsonIgnore
	@JsonManagedReference
	public Owner getOwner(){
		return this.owner_id;
	}
	public void setOwner(Owner owner){
		this.owner_id=owner;
	}
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JsonBackReference
	public Set<Medicine> getPetMedicines(){
		return this.medicines;
	}
	public void setPetMedicines(Set<Medicine> medicine){
		this.medicines =medicine;
	}
}