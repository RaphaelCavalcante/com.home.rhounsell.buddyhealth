package com.home.rhounsell.buddyhealth.controller;

import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Session;

import com.home.rhounsell.buddyhealth.HibernateUtil;
import com.home.rhounsell.buddyhealth.model.Medicine;

public class MedicineController {
	@Inject PetController petController;

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
		Medicine medicine = (Medicine) session.get(Medicine.class, medicineId);
		session.flush();
		session.getTransaction().commit();
		return medicine;
	}
	public Medicine createMedicine(Medicine medicine){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(medicine);
		session.flush();
		session.getTransaction().commit();
		return medicine;
	}
	public void updateMedicine(Medicine medicine){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(medicine);
		session.flush();
		session.getTransaction().commit();
	}
	public void deleteMedicine(Integer medicineId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Medicine medicine= (Medicine) session.load(Medicine.class, medicineId);
		String sql= "DELETE FROM Medicine WHERE medicine_id='"+medicine.getMedicineId()+"'";
		session.createQuery(sql).executeUpdate();
		session.flush();
		session.getTransaction().commit();
	}
}
