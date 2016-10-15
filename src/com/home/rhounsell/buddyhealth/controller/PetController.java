package com.home.rhounsell.buddyhealth.controller;

import java.util.Date;

import org.hibernate.Session;

import com.home.rhounsell.buddyhealth.HibernateUtil;
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
//		session.getTransaction().commit();
		session.flush();
		session.close();
		return pet;
	}
	public void createPet(Pet pet){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(pet);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void updatePet(Pet pet){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(pet);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void deletePet(Integer petId){
		Pet pet = this.getPetById(petId);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(pet);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
}