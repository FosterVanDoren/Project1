package com.troy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
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
			EmployeeDAO daoE = EmployeeDAOFactory.getEmployeeDao();
			Employee emp= daoE.getEmployeeLogin(username, password);;
			
			
//			Employee emp = daoE.getEmployeeLogin(username, password);	
			HttpSession session = request.getSession();
			session.setAttribute("id", emp.getEmpId());
			
//			if  (emp.getStatus() == "Employee") {
//				RequestDispatcher rd = request.getRequestDispatcher("ShowTicketsEMPServlet");
//				rd.forward(request, response);
//			}else if (emp.getStatus() == "Finance Manager") {
//				RequestDispatcher rd = request.getRequestDispatcher("ShowTicketsFMServlet");
//				rd.forward(request, response);
//			}else {
//				out.println("Sorry invalid username and password");
//				RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
//				rd.include(request, response);
//			}
			
			out.println("Hello, " + emp.getEmpId() +", " + emp.getStatus());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
