package com.home.rhounsell.buddyhealth.resource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.rhounsell.buddyhealth.controller.PetController;
import com.home.rhounsell.buddyhealth.model.Medicine;
import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;

@Path("pet")
public class PetResource {
	@Context
	UriInfo uriInfo;
	
	@Inject private PetController petController;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Pet getPet(@PathParam("id") Integer id){
		Pet pet= petController.getPetById(id);
		if(pet == null){
			throw new RuntimeException("Get: Pet with "+ id + " not found");
		}
		return pet;
	}
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newPet(
			@FormParam("name") String name, 
			@FormParam("birth_date") String birthDate,
			@FormParam("age") Integer age,
			@FormParam("breed") String breed,
			@FormParam("species") String species,
			@FormParam("owner") String ownerJSON) throws ParseException{
		Pet pet = new Pet(name, age);
		pet.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse(birthDate));
		pet.setBreed(breed);
		pet.setOwner(getOwnerJson(ownerJSON));
		pet.setSpecies(species);
		petController.createPet(pet);
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putPet(Pet pet){
		return putAndGetResponse(pet);
	}

	@GET
	@Path("/{id}/medicines")
	@Produces({MediaType.APPLICATION_JSON})
	public Set<Medicine> getPetMedicines(@PathParam("id") Integer id){
		Set<Medicine> petMedicines = petController.getPetMedicines(id);
		if(petMedicines == null){
			throw new RuntimeException("Get: pet doesn't have medicines");
		}
		return petMedicines;
	
	}
	private Owner getOwnerJson(String ownerJSON){
		ObjectMapper mapper = new ObjectMapper();
		Owner owner = new Owner();
		try {
			owner = (Owner) mapper.readValue(ownerJSON,  Owner.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return owner;
	}
	
	private Response putAndGetResponse(Pet pet){
		Response res;
		if(petController.getPetById(pet.getId())!=null){
			res=Response.created(uriInfo.getAbsolutePath()).build();
		}else{
			res= Response.noContent().build();
		}
		petController.updatePet(pet);
		return res;
	}
	
	
}
