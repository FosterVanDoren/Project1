package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowTicketsFMServlet extends HttpServlet{
	//Finance Manager
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			TicketDaoImpl dao = new TicketDaoImpl();
			List<Ticket> tickets  = dao.getTickets();
			
			
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
//			for(int i =0; i < ticket.size(); i++) {
				out.println("<tr>\r\n"
						+ "                <td>" + ticket.getTransId() +"</td>\r\n"
						+ "                <td>"+ ticket.getEmpId()+ "</td>\r\n"
						+ "                <td>"+ ticket.getrType()+"</td>\r\n"
						+ "                <td>"+ ticket.getDate()+"</td>\r\n"
						+ "                <td>"+ ticket.getrReason()+"</td>\r\n"
						+ "                <td>"+ ticket.getrAmount()+"</td>\r\n"
						+ "                <td>"+ ticket.getStatus()+"</td>\r\n"
						+ "                <td> <a href='/EditTicket.html'>Edit</a> </td>\r\n"
						+ "                <td>Delete</td>\r\n"
						+ "            </tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
