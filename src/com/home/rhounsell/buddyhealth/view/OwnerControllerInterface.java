package com.home.rhounsell.buddyhealth.view;

import java.util.Set;

import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;

public interface OwnerControllerInterface {
	public Owner getOwnerById(Integer ownerId);
	public void createOwner(Owner newOwner);
	public void updateOwner(Owner owner);
	public void deleteOwner(Integer ownerId);
	public Set<Pet> getOwnerPets(Integer ownerId);
}
