package com.home.rhounsell.buddyhealth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Medicine {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String medicineName;
	private Date startDate;
	private Date endingDate;
	
	public Medicine(){}
	
	public Medicine(String medicineName, Date startDate, Date endingDate){
		this.medicineName = medicineName;
		this.startDate = startDate;
		this.endingDate = endingDate;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}
	
	
}
