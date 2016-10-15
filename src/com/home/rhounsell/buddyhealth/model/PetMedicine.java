package com.home.rhounsell.buddyhealth.model;

import java.beans.Transient;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="pet_medicine", catalog="buddyhealth")
@AssociationOverrides({
	@AssociationOverride(name = "pk.pet", joinColumns = @JoinColumn(name="pet_id")),
	@AssociationOverride(name = "pk.medicine", joinColumns = @JoinColumn(name="medicine_id"))
})
public class PetMedicine implements java.io.Serializable{
	private PetMedicineId pk = new PetMedicineId();

	public PetMedicine(){}
	
	@EmbeddedId
	public PetMedicineId getPk(){
		return pk;
	}
	public void setPk(PetMedicineId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Pet getPet(){
		return getPk().getPet();
	}
	public void setPet(Pet pet){
		getPk().setPet(pet);
	}
	
	@Transient
	public Medicine getMedicine(){
		return getPk().getMedicine();
	}
	public void setMedicine(Medicine medicine){
		getPk().setMedicine(medicine);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PetMedicine that = (PetMedicine) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
