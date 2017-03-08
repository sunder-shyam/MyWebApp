package com.sundergs.learning.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest hreq=(HttpServletRequest) request;
		

		System.out.println(hreq.getRequestURI());
		
		if (hreq.getRequestURI().contains("login") || hreq.getRequestURI().contains("logout") ) {
			
			chain.doFilter(request, response);
		} else {

			Cookie cookies[]=hreq.getCookies();
			boolean loginFlag=false;
			if(cookies!=null && cookies.length>0) {
				for(Cookie ck:cookies) {
					if("user".equalsIgnoreCase(ck.getName())) {
						loginFlag=true;
					}

				}
			}
			if(loginFlag) {
				chain.doFilter(request, response);
			} else {
				HttpServletResponse hres=(HttpServletResponse) response ;
		
				@SuppressWarnings("deprecation")
				String targetURLEncoded = URLEncoder.encode( hreq.getRequestURI());
				hres.sendRedirect("http://localhost:8080/MyWebApp/login.jsp?target="+targetURLEncoded);
			}
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) {
	}



}
