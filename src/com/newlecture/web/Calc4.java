package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc4")
public class Calc4 extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 쿠키 저장소
		Cookie[] cookies = request.getCookies();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v= 0;
		
		// v 값 지정
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		if(op.equals("=")) {
			
//			Cookie c = cookies[0];
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = v;
			
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
				
				
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + y;
			} else {
				result = x- y;
			}
			
			out.println("result : " + result);
		} else {

			//cookie (반드시 url에 사용할 수 있는 문자열만 저장가능)
			Cookie valuecookie = new Cookie("value", String.valueOf(v));
			Cookie opcookie = new Cookie("op", op);
			
			// cookie의 maxAge(만료시점) 지정
			valuecookie.setMaxAge(24*60*60);
			
			// cookie 어느 경우에 사용자에게 전달해야하는지 경로 
			valuecookie.setPath("/");
			opcookie.setPath("/");
			
			// 브라우저에게 쿠키 전달
			response.addCookie(valuecookie);
			response.addCookie(opcookie);
		
			response.sendRedirect("calc4.html");
		}
		
		
		
	
	}
}
