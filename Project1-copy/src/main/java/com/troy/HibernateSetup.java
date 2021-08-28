package com.troy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSetup {
	
	protected static SessionFactory factory;
	
	public HibernateSetup() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
	}
}
