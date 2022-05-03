package com.edu.sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;




//
//HttpSessionBindingListener 를 구현하여 세션에 바인딩 이벤트를 처리하는 이벤트 핸들러를 구현한다.
//
public class LoginImpl implements HttpSessionBindingListener {

	String	user_id;
	String	user_pw;
	// 로그인을 하면 total_user를 증가시키기 위해 static을 사용한다.
	// 세션에 바인딩시 1씩 증가시킨다.
	static int total_user = 0;
	
	
	//
	//기본 생성자
	public LoginImpl() {}
	
	//
	//매개 변수가 있는 생성자
	public LoginImpl(String user_id, String user_pw) {
		this.user_id	= user_id;
		this.user_pw	= user_pw;
	}
	
	//
	//구현 객체가 세션에 바인딩 될 떄 호출된다.
	//세션에 저장시 접속자수를 증가시킨다
	//
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속");
		++total_user;
		
	}
	
	//
	// 구현 객체가 세션에서 언바인딩(제거)될때 호출된다.
	// 세션에서 소멸시 접속자 수를 감소시킨다.
	//
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자 접속 해제");
		total_user--;
		
	}
	
	
	
	
}//End -public class LoginImple implements HttpSessionBindingListener
