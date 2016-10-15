package com.home.rhounsell.buddyhealth;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;  
    private static final ServiceRegistry serviceRegistry;  
      
    static {  
        Configuration conf = new Configuration();  
        conf.configure();  
        serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        try {  
            sessionFactory = conf.buildSessionFactory(serviceRegistry);  
        } catch (Exception e) {  
            System.err.println("Initial SessionFactory creation failed." + e);  
            throw new ExceptionInInitializerError(e);  
        }         
    }  
      
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
}
