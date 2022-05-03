package com.edu.sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//
//매핑 이름에 상관없이 확장자가 .do면 실행이된다.
//
//@WebServlet("*.do") //확장자만 일치하는 패턴일 경우
public class TestServlet3 extends HttpServlet {
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
		out.println("<title>Text Sevlet 3</title>");
		out.println("</head>");
		out.println("<body bgcolor='red'>");
		out.println("<h1>Test Servlet 3</h1>");
		out.println("<h2>컨텍스트 명 : " + context 	+ "</h2>");
		out.println("<h2>전체 경로 : " 	 + url 		+ "</h2>");
		out.println("<h2>매핑 명 : " 	 + mapping 	+ "</h2>");
		out.println("<h2>URI : " 		 + uri 		+ "</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
}
