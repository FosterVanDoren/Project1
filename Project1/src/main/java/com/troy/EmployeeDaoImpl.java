package com.troy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	public EmployeeDAOImpl() {}

	@Override
	public Employee getEmployeeLogin(String username, String password) throws SQLException {
		Employee emp = new Employee();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Employee where username= :un AND password = :pw";
			Query query = session.createQuery(hql);
			query.setParameter("un", emp.getUsername());
			query.setParameter("pw", emp.getPassword());
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
		return emp;
	}

	@Override
	public List<Employee> getEmployees() throws SQLException {
		List<Employee> emp = new ArrayList();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from Employee";
			Query query = session.createQuery(hql);
			emp = query.list();
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
		return emp;
	}
	

}
