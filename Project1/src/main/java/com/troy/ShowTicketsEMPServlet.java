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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		try {
			TicketDaoImpl dao = new TicketDaoImpl();
			List<Ticket> tickets  = dao.getTicketById(id);
			
			
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
