package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.User;

public class interceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println("---1111111---");
		String requestURI = request.getRequestURI();
		if (!requestURI.contains("login")) {
			User user = (User) request.getSession().getAttribute("USER_SESSION");
			if (user==null) {
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	
}
