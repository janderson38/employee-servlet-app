package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class RequestHelper {

	// employeeservice
	private static EmployeeService eserv = new EmployeeService(new EmployeeDao());

	private static ObjectMapper om = new ObjectMapper();

	/**
	 * What does this method do?
	 * 
	 * It extracts the parameters from a request (username and password) from the UI
	 * It will call the confirmLogin() method from the EmployeeService and see if a
	 * user with that username and password exists
	 * 
	 * Who will provide the method with the HttpRequest? The UI We need to build an
	 * html doc with a form that will send these parameters to the method
	 */

	public static void processLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 1. Extract the parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee e = eserv.confirmLogin(username,  password);
		
		if(e.getId()>0) {
			HttpSession session = request.getSession();
			
			session.setAttribute("the-user", e);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<h1>Welcome " + e.getFirstName() + "!</h1>");
			out.println("<h3>You have successfully logged in!!</h3>");
			
		String jsonString = om.writeValueAsString(e);
		out.println(jsonString);
		
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("No user found, sorry");
			//response.setStatus(204); //204 means sucessful connection to the server, but no content found
			
			
		}

	}
}
