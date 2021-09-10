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
			String hql = "insert into Ticket (date, empId, rAmount, rReason, rType, status) Select(?,?,?,?,?,?)";
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
			transaction = session.beginTransaction();
			session.update(ticket);
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
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tick;
	}

	@Override
	public List<Ticket> getTicketById(int id) throws SQLException {
		List<Ticket> ticket = new ArrayList();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Ticket where emp_id= :ei";
			Query query = session.createQuery(hql);
			query.setParameter("ei", id);
			ticket = query.list();
			transaction = session.beginTransaction();
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

	@Override
	public List<Ticket> getTicketByStatus(String status) throws SQLException {
		List<Ticket> ticket = new ArrayList();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Ticket where status= :s";
			Query query = session.createQuery(hql);
			query.setParameter("s", status);
			ticket = query.list();
			transaction = session.beginTransaction();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}

}
