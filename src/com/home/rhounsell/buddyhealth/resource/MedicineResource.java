package com.home.rhounsell.buddyhealth.resource;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.rhounsell.buddyhealth.controller.MedicineController;
import com.home.rhounsell.buddyhealth.model.Medicine;
import com.home.rhounsell.buddyhealth.model.Pet;

@Path("medicine")
public class MedicineResource {
	@Context
	UriInfo uriInfo;
	
	@Inject MedicineController medicineController;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Medicine getMedicineById(@PathParam("id") Integer medicineId){
		Medicine medicine= medicineController.getMedicineById(medicineId);
		if(medicine == null){
			throw new RuntimeException("Get: Medicine with "+ medicineId+" not found");
		}
		return medicine;
	}
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newMedicine(
			@FormParam("name") String name,
			@FormParam("description") String description,
			@FormParam("first_dose") String firstDose,
			@FormParam("last_dose") String lastDose,
			@FormParam("dosage") String dosage,
			@FormParam("notes") String notes,
			@FormParam("petJson") String petJson) throws ParseException{
		Date firstDoseDate= new SimpleDateFormat("dd-MM-yyyy").parse(firstDose);
		Date lastDoseDate= new SimpleDateFormat("dd-MM-yyyy").parse(lastDose);
		
		Medicine medicine = new Medicine(
				name,
				description,
				firstDoseDate,
				lastDoseDate,
				dosage,
				notes
				);
		medicine.getPets().add(getPetFromJson(petJson));
		medicineController.createMedicine(medicine);
	}
	@PUT
	@Path("/updtate")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putMedicine(Medicine medicine){
		return putAndGetResponse(medicine);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteMedicine(@PathParam("id") String id){
		Medicine medicine= medicineController.getMedicineById(Integer.valueOf(id));
		if(medicine != null){
			medicineController.deleteMedicine(medicine.getMedicineId());
		}else{
			throw new RuntimeException("DELETE: medicine unknown");
		}
	}
	
	private Pet getPetFromJson(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Pet object = new Pet();
		try {
			object = mapper.readValue(jsonString, Pet.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}

	private Response putAndGetResponse(Medicine medicine){
		Response res;
		if(medicineController.getMedicineById(medicine.getMedicineId()) != null){
			res= Response.created(uriInfo.getAbsolutePath()).build();
		}else{
			res= Response.noContent().build();
		}
		medicineController.updateMedicine(medicine);
		return res;
	}
}
