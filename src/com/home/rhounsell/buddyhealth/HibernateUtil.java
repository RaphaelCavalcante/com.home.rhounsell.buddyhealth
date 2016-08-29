package com.home.rhounsell.buddyhealth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final Session session;
	
	private static buildSessionFactory (){
		Configuration conf = new Configuration();
		
		sessionFactory  = new StandardServiceRegistryBuilder();
		
	}
}
