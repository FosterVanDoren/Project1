package com.troy;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO {
	void addTicket (Ticket ticket) throws SQLException;
	void updateTicket (Ticket ticket) throws SQLException;
	void deleteTicket (int id) throws SQLException;
	List<Ticket> getTickets() throws SQLException;
	List<Ticket> getTicketById(int id) throws SQLException;
}
