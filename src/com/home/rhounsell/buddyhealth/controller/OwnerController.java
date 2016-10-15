package com.home.rhounsell.buddyhealth.controller;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.home.rhounsell.buddyhealth.HibernateUtil;
import com.home.rhounsell.buddyhealth.model.Owner;
import com.home.rhounsell.buddyhealth.model.Pet;

public class OwnerController {
	private Owner owner;
 
	
	public OwnerController(){
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
		//session.getTransaction().commit();
		session.flush();
		session.close();
		return owner;
	}
	public void createOwner(Owner newOwner){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(newOwner);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void updateOwner(Owner owner){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(owner);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void deleteUser(Integer ownerId){
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner= (Owner) session.load(Owner.class, ownerId);
		session.delete(owner);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public Set<Pet> getOwnerPets(Integer ownerId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Owner owner = (Owner) session.load(Owner.class, ownerId);
	//	session.getTransaction().commit();
		session.close();
		session.flush();
		return owner.getOwnerPets();
	}
}
