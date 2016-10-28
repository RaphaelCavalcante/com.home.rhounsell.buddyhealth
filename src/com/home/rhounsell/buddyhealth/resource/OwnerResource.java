package com.home.rhounsell.buddyhealth.resource;

import java.util.Set;

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

import com.home.rhounsell.buddyhealth.controller.OwnerController;
import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;

@Path("owner")
public class OwnerResource {
	@Context
	UriInfo uriInfo;
	
	@Inject private OwnerController ownerController;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Owner getOwner(@PathParam("id") Integer id){
		Owner owner = ownerController.getOwnerById(id);
		
		if(owner == null){
			throw new RuntimeException("Get: Owner with "+ id +" not found");
		}
		return owner;
	}
	@GET
	@Path("/{id}/pets")
	@Produces({MediaType.APPLICATION_JSON})
	public Set <Pet> getOwnerPets(@PathParam("id") Integer id){
		Set <Pet> ownerPets = ownerController.getOwnerPets(id);
		if(ownerPets == null){
			throw new RuntimeException("Get: Owner doesn't have pets");
		}
		return ownerPets;
	}
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newOwner(@FormParam("name") String name,
			@FormParam("phone") String phone){
		Owner owner = new Owner(name, phone);
		ownerController.createOwner(owner);
		//servletResponse.sendRedirect("");
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putOwner(Owner owner){
		//Owner c = owner.getValue();
		System.out.println(owner);
		return putAndGetResponse(owner);
	}
		
	@DELETE
	@Path("/{id}")
	public void deleteOwner(@PathParam("id") String id){
		Owner owner = ownerController.getOwnerById(Integer.valueOf(id));
		if(owner != null){
			ownerController.deleteOwner(owner.getOwnerId());
		}else{
			throw new RuntimeException("DELETE: User Unknown");
		}
	}
	
	private Response putAndGetResponse(Owner owner){
		Response res;
		if(ownerController.getOwnerById(owner.getOwnerId()) != null){
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}else{
			res=Response.noContent().build();
		}
		
		ownerController.updateOwner(owner);
		return res;
	}
}
