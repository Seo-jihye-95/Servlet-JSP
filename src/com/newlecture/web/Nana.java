package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");	// 사용자가 보내는 코딩 방식
		resp.setContentType("text/html; charset=UTF-8");	// 어떻게 해석할것인가의 방식 (UTF-8로 보낼것이니 UTF-8로 읽어라/이 문서는 html이므로 br태그를 br태그로 인식한다.)
		
		PrintWriter out = resp.getWriter();
		
//		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		String temp = req.getParameter("cnt");
		int cnt = 100;
		if(temp != null && !temp.equals("")) {
			cnt = Integer.parseInt(temp);
		}
		
		for(int i =0; i<cnt; i++) {
			out.println((i+1) + " : 안녕 Servlet!!<br/>");
		}
	}
}
