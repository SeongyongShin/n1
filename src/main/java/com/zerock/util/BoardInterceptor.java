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
		/*���ǰ��� �޾Ƽ� user_id �� null �̶�� login�������� sendRedirect
		 * ��, �Ķ���� ������ check=del;
		 * 
		 * �Խ���modify��û, delete ��û, update ��û, delete ��û�� ���ؼ�
		 * ������ �������Ͽ��� BoardIntercepter ���� ������ ó��
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
