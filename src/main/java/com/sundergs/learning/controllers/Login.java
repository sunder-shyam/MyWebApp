package com.sundergs.learning.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login 	 extends HttpServlet  {
			private static final long serialVersionUID = 1L;
			public void init() throws ServletException {
			}
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				PrintWriter out= response.getWriter();
				

				
				String uname=(String) request.getParameter("uname");
				String pwd=(String) request.getParameter("pwd");
				String target=(String) request.getParameter("target");
				String targetDecoded = URLDecoder.decode(target);
				
				Cookie userCookie = new Cookie("user",uname );
				response.addCookie(userCookie);
				out.println("<html><body>");
				out.println("Name : "+uname);
				out.println("<br>");
				out.println("pwd : "+pwd);
				out.println("</body></html>");
				
				if(target !=null ) {
					response.sendRedirect(targetDecoded);
				}

				
			
			}
			
			private boolean checkUser() {
				return true;
			}
			
		
}
