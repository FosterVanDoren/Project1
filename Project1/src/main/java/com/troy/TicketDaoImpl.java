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
		
		try {
			Session session = HibernateSetup.getFactory().openSession();
			String hql = "insert into Ticket (date, empId, rAmount, rReason, rType) Select(?,?,?,?,?)";
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
//			String hql = "update Ticket set status= :s where trans_Id = :ti";
//			String hql = "update Ticket set reimbursement_type= :rt, reimburse_amount= :ra, status= :s where trans_id = :ti";
//			Query query = session.createQuery(hql);
			transaction = session.beginTransaction();
//			query.setParameter("rt", tick.getrType());
//			query.setParameter("ra", tick.getrAmount());
//			query.setParameter("s", tick.getStatus());
//			query.setParameter("ti", tick.getTransId());
			session.update(ticket);
//			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTicket(int id) throws SQLException {
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "delete from Ticket  where trans_id= :tid";
			Query query = session.createQuery(hql);
			query.setParameter("tid", id);
			transaction = session.beginTransaction();
			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Ticket> getTickets() throws SQLException {
		List<Ticket> tick = new ArrayList();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Ticket";
			Query query = session.createQuery(hql);
			tick = query.list();
			transaction = session.beginTransaction();
//			int result = query.executeUpdate();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tick;
	}

	@Override
	public List<Ticket> getTicketById(int id) throws SQLException {
//		Ticket tick = new Ticket();
		List<Ticket> ticket = new ArrayList();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Ticket where emp_id= :ei";
			Query query = session.createQuery(hql);
			query.setParameter("ei", id);
			ticket = query.list();
//			ticket.add(tick);
			transaction = session.beginTransaction();
//			List result = query.list();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

	@Override
	public Ticket getTicketByTransId(int id) throws SQLException {
		Ticket ticket = new Ticket();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Ticket where trans_id= :ti";
			Query query = session.createQuery(hql);
			query.setParameter("ti", id);
			transaction = session.beginTransaction();
			ticket = (Ticket) query.uniqueResult();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

}
