package com.home.rhounsell.buddyhealth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class History {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Lob
	private String notes;
	
	public History(){}
	
	public History (String notes){
		this.notes= notes;
	}
	
	public void setNotes(String notes){
		this.notes = notes;
	}
	public String getNotes(){
		return notes;
	}
}
