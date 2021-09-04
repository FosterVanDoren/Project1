package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteTicketServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Ticket ticket = new Ticket();
		int tick = ticket.getTransId();
		try {
			TicketDaoImpl dao = new TicketDaoImpl();
			dao.deleteTicket(tick);
			out.println("Employee record inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
