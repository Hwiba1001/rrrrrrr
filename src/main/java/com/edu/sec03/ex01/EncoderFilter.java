package com.edu.sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


//
// @WebFilter("/*") 애너테이션을 이용하여 모든 요청이 필터를 거치게 만든다.
// 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 한다.
//
//@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {

	ServletContext context;
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("UTF-8 인코딩 필터 초기화.....");
		context = fConfig.getServletContext();
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("doFilter가 호출되었습니다.");
		
		//한글 인코딩 설정 작업을 한다.
		request.setCharacterEncoding("utf-8");
		
		// 웹 어플리케이션 컨텍스트 이름을 가져온다.
		String	context 	= ((HttpServletRequest) request).getContextPath();
		
		// 웹 브라우저에서 요청한 URI를 가져온다.
		String	pathInfo	= ((HttpServletRequest) request).getRequestURI();
		
		// 요청 URI의 실제 경로를 가져온다.
		String	realPath	= request.getRealPath(pathInfo);
		
		String	msg			= "Context 정보 : " + context 	+"\n"
							+ "URI 정보 : " 	+ pathInfo	+"\n"
							+ "물리적 정보 : "	+ realPath;
		System.out.println(msg);
		
		// 요청 필터에서 요청 처리 전의 시간을 구한다
		long	begin	= System.currentTimeMillis();
		//
		// 요청 필터 기능 : chain.doFilter(request, response); 앞에 기술한다.
		//
		chain.doFilter(request, response);
		//
		//응답 필터 기능 : chain.doFilter(request, response); 뒤에 기술한다.
		//
		//응답 필터에서 요청 처리 후의 시간을 구한다.
		long	end		= System.currentTimeMillis();
		
		// 작업 요청 전과 후의 차를 구해서 작업 수행 시간을 구한다.
		System.out.println("작업 소요 시간 : " + (end - begin) + " ms");
		
		
	}


	public void destroy() {
		System.out.println("destroy가 호출되었습니다.");

	}



}//End - public class EncoderFilter extends HttpFilter implements Filter
