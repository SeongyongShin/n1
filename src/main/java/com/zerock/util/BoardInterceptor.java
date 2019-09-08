package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*세션값을 받아서 user_id 가 null 이라면 login페이지로 sendRedirect
		 * 단, 파라미터 값으로 check=del;
		 * 
		 * 게시판modify요청, delete 요청, update 요청, delete 요청에 대해서
		 * 스프링 설정파일에서 BoardIntercepter 관련 설정을 처리
		 * */
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id") == null) {
			response.sendRedirect("/MyWeb/member/login?check=del");
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	
}
