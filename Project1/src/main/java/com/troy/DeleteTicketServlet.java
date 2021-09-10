package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteTicketServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String status= (String) session.getAttribute("status");
		
		
		
		int tid = Integer.parseInt(request.getParameter("id"));
		
		out.println(tid);
		try {
			TicketDAO dao = TicketDAOFactory.getTicketDao();
			dao.deleteTicket(tid);
			out.println("Employee record deleted");
			if(status.equals("employee")) {
			RequestDispatcher rd = request.getRequestDispatcher("/TicketsEMP"); // /AddTicket.html or /TicketsEMP
			rd.forward(request, response);
			}else if(status.equals("finance manager")) {
				RequestDispatcher rd = request.getRequestDispatcher("/TicketsFM"); // /AddTicket.html or /TicketsEMP
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
