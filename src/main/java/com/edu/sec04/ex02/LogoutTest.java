package com.edu.sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//
//
//
@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletContext	context;
	//
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);

		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out 	= response.getWriter();
		HttpSession session	= request.getSession();
		
		// user_list에서 삭제할 아이디를 가져온다.
		String user_id = request.getParameter("user_id");
		// 로그아웃시 세션을 소멸시킨다.
		session.invalidate();
		
		
		//user_list에서 로그아웃한 접속자 아이디를 삭제한 후 다시 user_list를 context에 저장한다.
		List user_list = (ArrayList) context.getAttribute("user_list");	//context에서 사용자들의 정보를 가져온다.
		user_list.remove(user_id);	// 사용자들의 정보에서 본인의 아이디를 삭제한다.
		
		//context의 user_id 자체를 없애버린다.
		context.removeAttribute("user_list");
		//context에 새로운 user_id(본인의 아이디를 제거한 사용자들의아이디)를 만든다.
		context.setAttribute("user_list", user_list);	
		out.println("로그아웃 되었습니다.");
				
	}
	
}// End - public class LogoutTest extends HttpServlet
