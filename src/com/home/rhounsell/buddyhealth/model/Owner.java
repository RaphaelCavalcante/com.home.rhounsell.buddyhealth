package com.home.rhounsell.buddyhealth.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table (name="owner", catalog="buddyhealth")
@XmlRootElement
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ownerId;
	private String name;
	private String phone;
	private Set <Pet> ownerPets= new HashSet<Pet>(0);
	
	public Owner(){}
	
	@JsonCreator
	public Owner(@JsonProperty("name") String name, @JsonProperty("phone") String phone){
		this.name=name;
		this.phone=phone;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="owner_id", unique=true, nullable=false)
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="phone", nullable=false, unique=true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@OneToMany(fetch=FetchType.LAZY, mappedBy="owner")
	@JsonBackReference
	public Set <Pet>getOwnerPets() {
		return ownerPets;
	}
	public void setOwnerPets(Set<Pet> ownerPets) {
		this.ownerPets = ownerPets;
	}
	
}
