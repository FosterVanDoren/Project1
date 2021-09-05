package com.troy;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements EmployeeDAO{
	
	public EmployeeDaoImpl() {}

	@Override
	public Employee getEmployeeLogin(String username, String password) throws SQLException {
		Employee employee = new Employee();
		Transaction transaction = null;
		try (Session session = HibernateSetup.getFactory().openSession()){
			String hql = "from employee where username= :un, password = :pw";
			Query query = session.createQuery(hql);
			query.setParameter("un", employee.getUsername());
			query.setParameter("pw", employee.getPassword());
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
		return employee;
	}
	

}
