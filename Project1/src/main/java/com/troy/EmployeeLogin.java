package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmployeeLogin extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
//			EmployeeDAO daoE = EmployeeDAOFactory.getEmployeeDao();
//			Employee emp= daoE.getEmployeeLogin(username, password);
			Employee emp = EmployeeDAOFactory.getEmployeeDao().getEmployeeLogin(username, password);
			
//			List<Employee> employees = new ArrayList();
//			employees.add(emp);
			
//			Employee emp = daoE.getEmployeeLogin(username, password);	
			HttpSession session = request.getSession();
			session.setAttribute("id", emp.getEmpId());
			session.setAttribute("status", emp.getStatus());
			
//			HttpSession session = request.getSession();
//			session.setAttribute("list", employees);
		
			
			if  (emp.getStatus().equals("employee")) {
				RequestDispatcher rd = request.getRequestDispatcher("/AddTicket.html"); // /AddTicket.html or /TicketsEMP
				rd.forward(request, response);
			}else if (emp.getStatus().equals("finance manager")) {
				RequestDispatcher rd = request.getRequestDispatcher("/TicketsFM");
				rd.forward(request, response);
			}else {
				out.println("Sorry invalid username and password");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
			
			out.println("Hello, " + emp.getEmpId() +", " + emp.getStatus());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
