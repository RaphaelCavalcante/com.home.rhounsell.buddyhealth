package com.home.rhounsell.buddyhealth.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table (name="medicine", catalog="buddyhealth")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medicine implements java.io.Serializable{
	
	private Integer medicineId;
	private String name;
	private String description;
	private Date firstDose;
	private Date lastDose;
	private String dosage;
	private String notes;
	private Set<Pet> pets = new HashSet<Pet>(0);
	
	public Medicine(){}
	public Medicine(String name, String description, Date firstDose, Date lastDose, String dosage, String notes){
		this.name=name;
		this.description= description;
		this.firstDose=firstDose;
		this.lastDose=lastDose;
		this.dosage=dosage;
		this.notes=notes;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="medicine_id", nullable=false, unique=true)
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="description", nullable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="first_dose", nullable=false)
	public Date getFirstDose() {
		return firstDose;
	}
	public void setFirstDose(Date firstDose) {
		this.firstDose = firstDose;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="last_dose", nullable=false)
	public Date getLastDose() {
		return lastDose;
	}
	public void setLastDose(Date lastDose) {
		this.lastDose = lastDose;
	}
	
	@Column(name="dosage",nullable=false)
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	@Column(name="notes", nullable=false)
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="pet_medicine", catalog="buddyhealth",
	joinColumns={
			@JoinColumn(name="medicine_id", nullable=false)},
	inverseJoinColumns= {
			@JoinColumn (name="pet_id", nullable=false)
	})
	@JsonManagedReference
	public Set <Pet> getPets(){
		return this.pets;
	}
	public void setPets(Set <Pet> pets){
		this.pets = pets;
		
	}	
}
