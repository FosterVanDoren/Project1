package com.troy;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

	List<Employee> getEmployees() throws SQLException;
	Employee getEmployeeLogin(String username, String password) throws SQLException;
	
}
