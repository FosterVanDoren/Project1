package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddTicketServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("reimbursement-select");
		double amount = Double.parseDouble(request.getParameter("rAmount"));
		String reason = request.getParameter("rReason");
		
		HttpSession sess = request.getSession(false);
		int id = (int) sess.getAttribute("id");
		
//		HttpSession sess = request.getSession(false);
//		List<Employee> emp= (List<Employee>) sess.getAttribute("list");
		
		Session session = HibernateSetup.getFactory().openSession();
		
		
		
		Ticket ticket = new Ticket();
		ticket.setDate(new Date());
		ticket.setEmpId(id);
		ticket.setrAmount(amount);
		ticket.setrReason(reason);
		ticket.setrType(type);
		
		
		
		try {
			Transaction transaction = session.beginTransaction();
//			TicketDAO daoT = TicketDAOFactory.getTicketDao();
//			daoT.addTicket(ticket);
			session.save(ticket);
			transaction.commit();
			
			out.println("Employee record inserted");
			
			RequestDispatcher rd = request.getRequestDispatcher("/TicketsEMP");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
