package com.troy;

import java.sql.SQLException;

public class EmployeeDAOFactory {
	private static EmployeeDAO daoE;
    private EmployeeDAOFactory(){}

    public static EmployeeDAO getEmployeeDao() throws SQLException {
        if (daoE == null){
            daoE = new EmployeeDAOImpl();
        } return daoE;
    }
}
