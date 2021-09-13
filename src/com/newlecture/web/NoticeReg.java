package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");	// 사용자가 보내는 코딩 방식
		resp.setContentType("text/html; charset=UTF-8");	// 어떻게 해석할것인가의 방식 (UTF-8로 보낼것이니 UTF-8로 읽어라/이 문서는 html이므로 br태그를 br태그로 인식한다.)
//		req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println("title : " + title);
		out.println("content : " + content);
	}
}
