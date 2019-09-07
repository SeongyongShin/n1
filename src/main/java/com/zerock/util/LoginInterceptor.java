package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//스프링 설정파일에 <interceptor>태그를 이용해 맵핑설정을 해야한다.

public class LoginInterceptor extends HandlerInterceptorAdapter{

	//컨트롤러를 실행하기 전에 요청을 가로채 처리한다.
	//로그인, 세션처리에 사용한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//세션검사 시작
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id") == null) {
			response.sendRedirect("/MyWeb/session/loginPage");
			
			return false;//핸들러 메서드 실행후 컨트롤러를 실행하지 않음. 구조를 생각하자 이거 인터셉터임
		}else {
			return true; // 들어온 요청 그대로 컨트롤러 ㄱ
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
		
	}
	//1. 인터셉터 클래스는 스프링에서 제공하는 HandlerIntercepterAdapter 클래스를 상속받아서 사용한다.
	//2. 일반적으로 preHandler, postHandler, afterCompletion 메서드를 오버라이딩해서 사용
	
	
}
