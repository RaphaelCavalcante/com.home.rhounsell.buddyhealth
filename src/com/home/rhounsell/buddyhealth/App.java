package com.home.rhounsell.buddyhealth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.home.rhounsell.buddyhealth.controller.MedicineController;
import com.home.rhounsell.buddyhealth.controller.OwnerController;
import com.home.rhounsell.buddyhealth.controller.PetController;
import com.home.rhounsell.buddyhealth.controller.PetMedicineController;
import com.home.rhounsell.buddyhealth.model.Medicine;
import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;
import com.home.rhounsell.buddyhealth.model.PetMedicine;

public class App {
	public static void main (String args[]){
		OwnerController ownerCtrl = new OwnerController();
		PetController petCtrl= new PetController();
		MedicineController medicineCtrl = new MedicineController();
		PetMedicineController petMedicineCtrl= new PetMedicineController();
		
		Pet pet = petCtrl.getPet();
		pet.setAge(5);
		try {
			pet.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse("08/05/2012"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pet.setBreed("dachshund");
		pet.setName("Hati");
		pet.setSpecies("Dog");
		
		Owner owner = ownerCtrl.getOwner();
		
		owner.setName("Raphael");
		owner.setPhone("12345-6789");
		
		ownerCtrl.createOwner(owner);
		
		pet.setOwner(owner);
		
		
		Medicine med= medicineCtrl.getMedicine();
		med.setName("medicamentoX");
		med.setDescription("medicamento");
		med.setDosage("12");
		med.setFirstDose(new Date());
		med.setLastDose(new Date());
		med.setNotes("dar");
		
		medicineCtrl.createMedicine(med);
		pet.getPetMedicines().add(med);
		
		
		petCtrl.createPet(pet);
		
		
	}
}
