package com.sundergs.learning.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><body>");
		out.println("<p1>HomePage</p1>");
		out.println("</body></html>");

	}
	
			



}
