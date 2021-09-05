package com.troy;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmployeeLogin extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee emp = new Employee();
		
		try {
			EmployeeDaoImpl daoE = new EmployeeDaoImpl();
			daoE.getEmployeeLogin(username, password);
			
//			out.println("<h1><a href='ShowTables?empId="+ emp.getEmpId() + "'>Click Here</a></h1>");
			
			HttpSession session = request.getSession();
			session.setAttribute("id", emp.getEmpId());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
