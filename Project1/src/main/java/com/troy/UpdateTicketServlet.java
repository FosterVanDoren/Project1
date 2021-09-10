package com.troy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateTicketServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession(false);
		int id = (int) sess.getAttribute("id");

		
		try {
			TicketDAO dao = TicketDAOFactory.getTicketDao();
			Ticket ticket = dao.getTicketByTransId(id);
			String status = request.getParameter("status-select");
			
			System.out.println(status);
			System.out.println(ticket.toString());
			
			ticket.setStatus(status);
			dao.updateTicket(ticket);
			
			System.out.println(ticket.toString());
			
			out.println("Employee record inserted");
			RequestDispatcher rd = request.getRequestDispatcher("/TicketsFM");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(request.getParameter("id"));
		
		

		
		try {
			int tid = Integer.parseInt(request.getParameter("id"));
			TicketDAO dao = TicketDAOFactory.getTicketDao();
			Ticket ticket = dao.getTicketByTransId(tid);
			
			request.setAttribute(request.getParameter("rAmount"), ticket.getrAmount());
			request.setAttribute("reimbursement-select", ticket.getrType());
			request.setAttribute("status-select", ticket.getStatus());
			
			String type = request.getParameter("reimbursement-select");
			double amount = Double.parseDouble(request.getParameter("rAmount"));
			String status = request.getParameter("status");
			
			ticket.setrType(type);
			ticket.setrAmount(amount);
			ticket.setStatus(status);
			dao.updateTicket(ticket);
			out.println("Employee record inserted");
			RequestDispatcher rd = request.getRequestDispatcher("/TicketsFM");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
