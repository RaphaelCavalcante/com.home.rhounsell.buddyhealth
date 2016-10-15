package com.home.rhounsell.buddyhealth.controller;

import org.hibernate.Session;

import com.home.rhounsell.buddyhealth.HibernateUtil;
import com.home.rhounsell.buddyhealth.model.PetMedicine;

public class PetMedicineController {
	
	
	public PetMedicineController(){
	}
	public void save(PetMedicine petMedicine){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(petMedicine);
		session.getTransaction().commit();
	//	session.flush();
		session.close();
	}
}
