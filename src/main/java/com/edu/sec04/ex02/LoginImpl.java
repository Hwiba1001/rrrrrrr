package com.edu.sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



//
// LoginImpl 클래스는 HttpSessionListener를 구현해서 세션의 생성과 소멸 시 이벤트를 처리하는 핸들러이다.
// HttpSessionListener는 반드시 리스너를 구현한 이벤트 핸들러를 애너테이션을 이용해서 등록해야 한다.
//
// HttpSessionBindingListener를 제외한
// Listener를 구현한 모든 이벤트 핸드러들은 반드시 애너테이션을 이용해서 Listener로 등록해야 한다.
//
@WebListener
public class LoginImpl implements HttpSessionListener {
	
	String	user_id;
	String	user_pw;
	static	int	total_user = 0;
	
	
	//
	//생성자
	//
    public LoginImpl() {}
    public LoginImpl(String user_id, String user_pw) {
    	this.user_id	= user_id;
    	this.user_pw	= user_pw;
    	
    }

    //
    //세션생성
    //
    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("HttpSessionListener sessionCreated()가 실행됩니다.");
        ++total_user;
    }

    //
    //세션소멸
    //
    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("HttpSessionListener sessionCreated()가 실행됩니다.");
        --total_user;
    }
	
}// End - public class LoginImpl implements HttpSessionListener
