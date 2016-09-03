package com.home.rhounsell.buddyhealth.view;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.home.rhounsell.buddyhealth.model.History;
import com.home.rhounsell.buddyhealth.model.Medicine;
import com.home.rhounsell.buddyhealth.model.Pet;

public interface PetInterface {
	public List<Pet> getPetList();
	public Pet getPet();
	public void addHistoryRegistry(String registry, Date historyDate);
	public void addMedicine(Medicine medicineRegistry);
/*	public Set<Medicine> getAllMedicine();
	public Set<History> getAllPetHistory();
	public History getPetHistoryRegistryByDate(Date date);
	public Medicine getMedicineRegistryByDate(Date date);
	public Medicine getMedicineRegistryByPeriod(Date startDate, Date endDate);*/
}
