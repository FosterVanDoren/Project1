package com.troy;

import java.sql.SQLException;

public class TicketDAOFactory {
	private static TicketDAO daoT;
    private TicketDAOFactory(){}

    public static TicketDAO getTicketDao() throws SQLException {
        if (daoT == null){
            daoT = new TicketDaoImpl();
        } return daoT;
    }
}
