package com.home.rhounsell.buddyhealth;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.home.rhounsell.buddyhealth.controller.OwnerController;
import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;

@Path("/hello")
public class Hello {
	@Inject	private OwnerController ownerController;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloBuddyHealthRestful(){
	//	OwnerController ownerController = new OwnerController();
		Owner owner = ownerController.getOwnerById(36);
		Set <Pet> ownerPets= owner.getOwnerPets();
		return String.valueOf(ownerPets.size());
	}
}
