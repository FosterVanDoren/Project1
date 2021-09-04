package com.troy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TicketDaoImpl implements TicketDAO{
	
	public TicketDaoImpl() {}

	@Override
	public void addTicket(Ticket ticket) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "insert into tickets (reimbursement_type, reimburse_reason, reimbusre_amount)" + 
					  	 "Select reimbursement_type, reimburse_reason,reimburse_amount";
			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}else {
			e.printStackTrace();
		}
		}
		
	}

	@Override
	public void updateTicket(Ticket ticket) throws SQLException {
		Transaction transaction = null;
		Ticket tick = new Ticket();
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "update tickets set reimbursement_type= :rt, reimburse_amount= :ra, status= :s";
			Query query = session.createQuery(hql);
			query.setParameter("rt", tick.getrType());
			query.setParameter("ra", tick.getrAmount());
			query.setParameter("s", tick.getStatus());
			transaction = session.beginTransaction();
			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}else {
			e.printStackTrace();
		}
		}
		
	}

	@Override
	public void deleteTicket(int id) throws SQLException {
		Transaction transaction = null;
		Ticket tick = new Ticket();
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "delete from tickets t where t.trans_id= :tid";
			Query query = session.createQuery(hql);
			query.setParameter("tid", tick.getTransId());
			transaction = session.beginTransaction();
			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}else {
			e.printStackTrace();
		}
		}
	}

	@Override
	public List<Ticket> getTickets() throws SQLException {
		List<Ticket> tick = new ArrayList();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from tickets";
			Query query = session.createQuery(hql);
			tick = query.list();
			transaction = session.beginTransaction();
			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}else {
			e.printStackTrace();
		}
		}
		return tick;
	}

	@Override
	public Ticket getTicketById(int id) throws SQLException {
		Ticket ticket = new Ticket();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from tickets where trans_id= :ti";
			Query query = session.createQuery(hql);
			query.setParameter("ti", ticket.getTransId());
			transaction = session.beginTransaction();
			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}else {
			e.printStackTrace();
		}
		}
		return ticket;
	}

}
