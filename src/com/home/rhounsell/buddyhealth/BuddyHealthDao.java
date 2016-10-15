package com.home.rhounsell.buddyhealth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BuddyHealthDao {
	private static SessionFactory sessionFactory;
	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public static <T> Object save(T entity){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		return entity;
	}
	
	public static <T> Object update(T entity){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();
		return entity;
	}
	
	public static <T> void delete(T entity){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}
	
}
