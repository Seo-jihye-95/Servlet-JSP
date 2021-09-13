package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//동일한 이름으로 값이 넘어올때는 getParameterValues로 받는다 (배열같은 느낌으로)
		String[] num_ = request.getParameterValues("num");
		
		int result =0 ;
		
		for(int i=0; i<num_.length; i++) {
			// 연산은 반복되지만 선언은 반복되지 않는다. 지역적으로 쓰기위해서 for문 안쪽에써서 지역번수를 만든다.
			int num = Integer.parseInt(num_[i]);
			result += num;
		}
		
		out.println("result : " + result);
	}
}
