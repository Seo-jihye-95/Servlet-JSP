package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 세션 저장소
		HttpSession session = request.getSession();
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("op");
		
		int v= 0;
		
		// v 값 지정
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		if(op.equals("=")) {
			int x = (Integer)session.getAttribute("value");
			int y = v;
			
			String operator = (String) session.getAttribute("op");
			
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + y;
			} else {
				result = x- y;
			}
			
			out.println("result : " + result);
		} else {

			//session
			session.setAttribute("value", v);
			session.setAttribute("op", op);
	}
		
		
		
	
	}
}
