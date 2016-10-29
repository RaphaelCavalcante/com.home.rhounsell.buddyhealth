package com.home.rhounsell.buddyhealth.controller;

import java.util.Date;
import java.util.Set;

import org.hibernate.Session;

import com.home.rhounsell.buddyhealth.HibernateUtil;
import com.home.rhounsell.buddyhealth.model.Medicine;
import com.home.rhounsell.buddyhealth.model.Pet;

public class PetController {
	private Pet pet;
	public PetController(){
		pet = new Pet();
	}
	public PetController(String name, Integer age, Date birthDate, String species){
		pet= new Pet();
		pet.setName(name);
		pet.setAge(age);
		pet.setBirthDate(birthDate);
		pet.setSpecies(species);
	}
	public Pet getPet(){
		return this.pet;
	}
	public Pet getPetById(Integer petId){
		Session session= HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Pet pet= (Pet) session.load(Pet.class, petId);
		session.flush();
		session.getTransaction().commit();
		return pet;
	}
	public void createPet(Pet pet){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(pet);
		session.flush();
		session.getTransaction().commit();
	}
	public void updatePet(Pet pet){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(pet);
		session.flush();
		session.getTransaction().commit();
	}
	public void deletePet(Integer petId){
		Pet pet = this.getPetById(petId);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(pet);
		session.flush();
		session.getTransaction().commit();
	}
	public Set<Medicine> getPetMedicines(Integer petId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Pet pet=(Pet) session.load(Pet.class, petId);
//		@SuppressWarnings("unchecked")
//		Set<Medicine> petMedicines = (Set<Medicine>) session.createQuery("SELECT medicine FROM pet_medicine WHERE pet_id="+petId+"");
		return pet.getPetMedicines();
	}
}