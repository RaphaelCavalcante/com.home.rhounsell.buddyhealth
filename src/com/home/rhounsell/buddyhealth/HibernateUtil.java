package com.home.rhounsell.buddyhealth;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory (){
		Configuration conf = new Configuration();
		conf.configure();
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		return conf.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
