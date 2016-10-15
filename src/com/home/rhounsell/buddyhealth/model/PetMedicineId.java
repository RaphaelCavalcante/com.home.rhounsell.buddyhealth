package com.home.rhounsell.buddyhealth.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class PetMedicineId implements java.io.Serializable{
	private Pet pet;
	private Medicine medicine;
	
	@ManyToOne
	public Pet getPet(){
		return pet;
	}
	
	public void setPet(Pet pet){
		this.pet=pet;
	}
	
	@ManyToOne
	public Medicine getMedicine(){
		return medicine;
	}
	public void setMedicine(Medicine medicine){
		this.medicine = medicine;
	}
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetMedicineId that = (PetMedicineId) o;

        if (pet != null ? !pet.equals(that.pet) : that.pet != null) return false;
        if (medicine != null ? !medicine.equals(that.medicine) : that.medicine != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (pet != null ? pet.hashCode() : 0);
        result = 31 * result + (medicine != null ? medicine.hashCode() : 0);
        return result;
    }
}
