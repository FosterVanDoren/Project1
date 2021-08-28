package com.troy;

import com.troy.HibernateSetup;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ShowTables extends HibernateSetup{
	
	public void listTickets() {
		HibernateSetup hs = new HibernateSetup();
		Session session = factory.openSession();
		Transaction tc = null;
		
		try {
			tc = session.beginTransaction();
			List employees = session.createQuery("FROM tickets").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Ticket ticket = (Ticket) iterator.next();
				System.out.print("Trans ID: " + ticket.getTransId());
				System.out.print("Emp ID: " + ticket.getEmpId());
				System.out.print("Reimbursement Type: " + ticket.getrType());
				System.out.print("Reimbursement Amount: " + ticket.getrAmount());
				System.out.print("Status: " + ticket.getStatus());
			}
			tc.commit();
		}catch (HibernateException e) {
			if (tc!=null) tc.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}