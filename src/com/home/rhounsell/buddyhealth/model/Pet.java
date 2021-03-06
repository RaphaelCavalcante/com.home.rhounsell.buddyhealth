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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="pet", catalog="buddyhealth")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pet implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer petId;
	private String name;
	private Integer age;
	private Date birthDate;
	private String breed;
	private String species;
	private Integer weight;
	private Owner owner_id;
	private Set<Medicine> petMedicines = new HashSet<Medicine>(0);
	public Pet(){}
	public Pet(String name, Integer age, Integer weight){
		this.name = name;
		this.age = age;
		this.weight= weight;
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
	@Column(name="weight", nullable=false)
	public Integer getWeight(){
		return this.weight;
	}
	public void setWeight(Integer weight){
		this.weight= weight;
	}
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id")
	public Owner getOwner(){
		return this.owner_id;
	}
	public void setOwner(Owner owner){
		this.owner_id=owner;
	}
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="pets")
	@JsonIgnore
	public Set<Medicine> getPetMedicines(){
		return this.petMedicines;
	}
	public void setPetMedicines(Set<Medicine> medicine){
		this.petMedicines = medicine;
	}
}