package com.troy;

import java.sql.SQLException;

public interface EmployeeDAO {

	Employee getEmployeeLogin(String username, String password) throws SQLException;
	
}
