package com.home.rhounsell.buddyhealth.controller;

import java.util.Date;

import org.hibernate.Session;

import com.home.rhounsell.buddyhealth.HibernateUtil;
import com.home.rhounsell.buddyhealth.model.Medicine;

public class MedicineController {
	private Medicine medicine;
	public MedicineController(){
		medicine= new Medicine();
	}
	public MedicineController(String name, String desc, Date firstDose, Date lastDose, String dosage, String notes){
		medicine = new Medicine(name, desc, firstDose, lastDose, dosage, notes);
	}
	public Medicine getMedicine(){
		return this.medicine;
	}
	public Medicine getMedicineById(Integer medicineId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Medicine medicine = (Medicine) session.load(Medicine.class, medicineId);
		//session.getTransaction().commit();
		session.flush();
		session.close();
		return medicine;
	}
	public void createMedicine(Medicine medicine){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(medicine);
//		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void updateMedicine(Medicine medicine){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(medicine);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
	public void deleteMedicine(Integer medicineId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Medicine medicine= this.getMedicineById(medicineId);
		session.delete(medicine);
		//session.getTransaction().commit();
		session.flush();
		session.close();
	}
}
