package com.sundergs.learning.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		

		
		String uname=(String) request.getParameter("uname");
		String pwd=(String) request.getParameter("pwd");
		
		Cookie userCookie = new Cookie("user",uname );
		userCookie.setMaxAge(0);
		response.addCookie(userCookie);
		
		out.println("<html><body>");
		out.println("Log Out");
		out.println("</body></html>");

		
	
	}
	
	private boolean checkUser() {
		return true;
	}
	

	
	
}
