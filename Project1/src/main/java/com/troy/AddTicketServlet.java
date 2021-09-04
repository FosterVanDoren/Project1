package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddTicketServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("reimbursement-select");
		double amount = Double.parseDouble(request.getParameter("rAmount"));
		String reason = request.getParameter("rReason");
		
		Ticket ticket = new Ticket();
		ticket.setrType(type);
		ticket.setrAmount(amount);
		ticket.setrReason(reason);
		
		try {
			TicketDaoImpl dao = new TicketDaoImpl();
			dao.addTicket(ticket);
			out.println("Employee record inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
