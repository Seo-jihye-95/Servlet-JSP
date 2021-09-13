package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 어플리케이션 저장소
		ServletContext application = request.getServletContext();
					
		
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");

		int v =0;

		// v 값 지정
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		// 계산
		if(op.equals("=")) {
			
			// 앞에서 저장했던 값 (application 저장소에 담겨져있던 value 내용)
			int x = (Integer) application.getAttribute("value");
			// 지금 사용자가 전달한 value 값
			int y =	v;
			// 앞에서 저장했던 값 (application 저장소에 담겨져있던 operator 내용)
			String operator = (String) application.getAttribute("op");
			
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + y;
			} else {
				result = x -y;
			}
			
			out.printf("result : " + result);
			
		} else {
			application.setAttribute("value", v);
			application.setAttribute("op", op);
		}
		
		
	}
}
