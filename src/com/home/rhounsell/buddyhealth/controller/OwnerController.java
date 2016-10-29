package com.home.rhounsell.buddyhealth.controller;

import java.util.Set;

import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.home.rhounsell.buddyhealth.BuddyHealthBinder;
import com.home.rhounsell.buddyhealth.HibernateUtil;
import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;
import com.home.rhounsell.buddyhealth.view.OwnerControllerInterface;

public class OwnerController extends ResourceConfig implements OwnerControllerInterface {
	private Owner owner;
 
	
	public OwnerController(){
		register(new BuddyHealthBinder());
		packages(true, "com.rhounsell.buddyhealth");
		owner= new Owner();
	}
	
	public OwnerController(String name, String phone){
		owner=new Owner (name, phone);
	}
	
	public Owner getOwner(){
		return this.owner;
	}
	public Owner getOwnerById(Integer ownerId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner = (Owner) session.load(Owner.class, ownerId);
		session.flush();
		session.getTransaction().commit();
		return owner;
	}
	public void createOwner(Owner newOwner){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(newOwner);
		session.flush();
		session.getTransaction().commit();
	}
	public void updateOwner(Owner owner){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(owner);
		session.flush();
		session.getTransaction().commit();
	}
	public void deleteOwner(Integer ownerId){
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner= (Owner) session.load(Owner.class, ownerId);
		session.delete(owner);
		session.flush();
		session.getTransaction().commit();
	}
	public Set<Pet> getOwnerPets(Integer ownerId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner = (Owner) session.load(Owner.class, ownerId);
		session.flush();
		session.getTransaction().commit();
		return owner.getOwnerPets();
	}
}
