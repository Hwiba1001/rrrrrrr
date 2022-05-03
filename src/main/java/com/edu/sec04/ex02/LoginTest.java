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
// LoginImpl loginUser = new LoginImpl(user_id, user_pw);를 실행하여 전송된 ID와 비밀번호를 저장한다.
// session.setAttribute("loginUser", loginUser);으로 세션에 바인딩시
// 미리 HttpSessionBindingListener를 구현한 LoginImpl의 valueBound() 메서드를 호출한다.
//
@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletContext context = null;
	//로그인한 접속자들의 ID를 저장하는 ArrayList
	List user_list = new ArrayList();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		
		PrintWriter out 	= response.getWriter();
		HttpSession session	= request.getSession();
		
		String	user_id = request.getParameter("user_id");
		String	user_pw = request.getParameter("user_pw");
		
		// 이벤트 핸들러를 생성한 후 세션에 저장한다.
		//loginImpl 객체를 생성한 후 전송된 아이디와 비밀번호를 저장한다.
		
		LoginImpl	loginUser	= new  LoginImpl(user_id, user_pw);
		
		// 최초 로그인시 접속자 ID를 ArrayList에 차례로 저장한 후
		// 다시 context 객체에 속성으로 저장한다.
		if(session.isNew() ) {
			//세션에 바인딩시 LoginImpl의 valueBound()메서드를 호출한다.
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		
		//자바스크립트의 setTimeout()함수를 이용하여 5초마다 서블릿에 재요청을 하여 현재 접속자수를 표시한다.
		out.println("<html>");
		out.println("<head>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>아 이 디 : " + loginUser.user_id +  "</h1>");
		// 총 접속자 수를 보여준다.
		out.println("<h2>총접속자 수 : " + LoginImpl.total_user + "</h2>");
		
		out.println("<h2>접속자들의 아이디</h2>");
		//context 객체의 ArrayList를 가져와 접속자 ID를 차례대로 보여준다.
		List list = (ArrayList) context.getAttribute("user_list");
		for(int i = 0; i< list.size(); i++) {
			out.println(list.get(i) + "<br/>");
		}
		out.println("<a href='logout?user_id=" + user_id + "'>로그아웃</a>");
		out.println("</body>");
		out.println("</html>");

	}

}//End - public class LoginTest extends HttpServlet
