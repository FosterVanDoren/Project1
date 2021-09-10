package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ShowTicketsEMPServlet extends HttpServlet{
	//Employee
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		
		try {
			List<Ticket> tickets  = TicketDAOFactory.getTicketDao().getTicketById(id);
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Employee Tickets Table</title>");
			out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">");
			out.println("  <style>\r\n"
					+ "        tr:nth-child(odd){\r\n"
					+ "    background-color: #511845;\r\n"
					+ "    color: White;\r\n"
					+ "}\r\n"
					+ "tr:nth-child(even){\r\n"
					+ "    background-color: #FF5733;\r\n"
					+ "    color: Black;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "    </style>");
			out.println("<body>");
			out.println("<div class=\"container\">");
			out.println(" <table class=\"table table-bordered\">\r\n"
					+ "        <thead >\r\n"
					+ "            <tr style=\"background-color: #C70039; color: White;\">\r\n"
					+ "                <th>TransID</th>\r\n"
					+ "                <th>EmpID</th>\r\n"
					+ "                <th>Type</th>\r\n"
					+ "                <th>Date</th>\r\n"
					+ "                <th>Reason</th>\r\n"
					+ "                <th>Amount</th>\r\n"
					+ "                <th>Status</th>\r\n"
					+ "                <th colspan=\"2\">Actions</th>\r\n"
					+ "            </tr>\r\n"
					+ "        </thead>");
			out.println("<tbody>");
			for(Ticket ticket : tickets) {
				out.println("<tr>\r\n"
						+ "                <td>"+ ticket.getTransId() +"</td>\r\n"
						+ "                <td>"+ ticket.getEmpId()+ "</td>\r\n"
						+ "                <td>"+ ticket.getrType()+"</td>\r\n"
						+ "                <td>"+ ticket.getDate()+"</td>\r\n"
						+ "                <td>"+ ticket.getrReason()+"</td>\r\n"
						+ "                <td>"+ ticket.getrAmount()+"</td>\r\n"
						+ "                <td>"+ ticket.getStatus()+"</td>\r\n"
						+ "                <td><a href='DeleteTicket?id=" +ticket.getTransId()+"'>Delete</td>\r\n"
						+ "            </tr>");
				HttpSession sess = request.getSession();
				sess.setAttribute("id", ticket.getTransId());
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("<a href=\"http://localhost:8080/Project1/AddTicket.html\" type=\"button\" class=\"btn btn-dark\">View Tickets</a>");
			out.println("</div>");
			out.println("</body>\r\n"
					+ "</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		
		try {
			List<Ticket> tickets  = TicketDAOFactory.getTicketDao().getTicketById(id);
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Employee Tickets Table</title>");
			out.println("  <style>\r\n"
					+ "        tr:nth-child(odd){\r\n"
					+ "    background-color: #511845;\r\n"
					+ "    color: #FF5733;\r\n"
					+ "}\r\n"
					+ "tr:nth-child(even){\r\n"
					+ "    background-color: #FF5733;\r\n"
					+ "    color: #511845;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "    </style>");
			out.println("<body>");
			out.println(" <table class=\"table table-bordered\">\r\n"
					+ "        <thead >\r\n"
					+ "            <tr style=\"background-color: #C70039; color: #511845;\">\r\n"
					+ "                <th>TransID</th>\r\n"
					+ "                <th>EmpID</th>\r\n"
					+ "                <th>Type</th>\r\n"
					+ "                <th>Date</th>\r\n"
					+ "                <th>Reason</th>\r\n"
					+ "                <th>Amount</th>\r\n"
					+ "                <th>Status</th>\r\n"
					+ "                <th colspan=\"2\">Actions</th>\r\n"
					+ "            </tr>\r\n"
					+ "        </thead>");
			out.println("<tbody>");
			for(Ticket ticket : tickets) {
				out.println("<tr>\r\n"
						+ "                <td>"+ ticket.getTransId() +"</td>\r\n"
						+ "                <td>"+ ticket.getEmpId()+ "</td>\r\n"
						+ "                <td>"+ ticket.getrType()+"</td>\r\n"
						+ "                <td>"+ ticket.getDate()+"</td>\r\n"
						+ "                <td>"+ ticket.getrReason()+"</td>\r\n"
						+ "                <td>"+ ticket.getrAmount()+"</td>\r\n"
						+ "                <td>"+ ticket.getStatus()+"</td>\r\n"
						+ "                <td><a href=\"/DeleteTicket\">Delete</td>\r\n"
						+ "            </tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("<a href=\"http://localhost:8080/Project1/AddTicket.html\" type=\"button\" class=\"btn btn-dark\">Add Ticket</a>");
			out.println("</body>\r\n"
					+ "</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
