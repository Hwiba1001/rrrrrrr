package com.edu.sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//
//정확히 경로와 이름까지 일치하는 URL패턴
//
//@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context 	= request.getContextPath(); // 컨텍스트 이름만 가져온다.
		String url		= request.getRequestURI().toString(); // 전체 URL을 가져온다.
		String mapping	= request.getServletPath(); // 서블릿 매핑 이름만 가져온다.
		String uri		= request.getRequestURI();	// URI를 가져온다.
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Text Sevlet 1</title>");
		out.println("</head>");
		out.println("<body bgcolor='green'>");
		out.println("<h1>Test Servlet 1</h1>");
		out.println("<h2>컨텍스트 명 : " + context 	+ "</h2>");
		out.println("<h2>전체 경로 : " 	 + url 		+ "</h2>");
		out.println("<h2>매핑 명 : " 	 + mapping 	+ "</h2>");
		out.println("<h2>URI : " 		 + uri 		+ "</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}// End - public class TestServlet1 extends HttpServlet
