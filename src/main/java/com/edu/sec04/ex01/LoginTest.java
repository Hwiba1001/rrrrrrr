package com.edu.sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//
// LoginImpl loginUser = new LoginImpl(user_id, user_pw);를 실행하여 전송된 ID와 비밀번호를 저장한다.
// session.setAttribute("loginUser", loginUser);으로 세션에 바인딩시
// 미리 HttpSessionBindingListener를 구현한 LoginImpl의 valueBound() 메서드를 호출한다.
//
//@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out 	= response.getWriter();
		HttpSession session	= request.getSession();
		
		String	user_id = request.getParameter("user_id");
		String	user_pw = request.getParameter("user_pw");
		
		// 이벤트 핸들러를 생성한 후 세션에 저장한다.
		LoginImpl	loginUser	= new  LoginImpl(user_id, user_pw);
		// 새로운 세션인지를 확인한다.
		// 세션이 만들어졌는지 boolean 타입으로 반환한다.
		// 세션이 새로 만들어 졌으면 true, 이미 만들어진 세션이면 false를 반환한다.
		if(session.isNew() ) {
			//세션에 바인딩시 LoginImpl의 valueBound()메서드를 호출한다.
			session.setAttribute("loginUser", loginUser);
		}
		
		//자바스크립트의 setTimeout()함수를 이용하여 5초마다 서블릿에 재요청을 하여 현재 접속자수를 표시한다.
		out.println("<html>");
		out.println("<head>");
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);',5000)");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>아 이 디 : " + user_id +  "</h1>");
		// 총 접속자 수를 보여준다.
		out.println("<h2>총접속자 수 : " + LoginImpl.total_user + "</h2>");
		out.println("</body>");
		out.println("</html>");

	}

}//End - public class LoginTest extends HttpServlet
