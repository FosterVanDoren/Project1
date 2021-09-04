package com.troy;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSetup {
	public static SessionFactory factory;
	
	public static SessionFactory getFactory() throws HibernateException {
		if(factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
}
