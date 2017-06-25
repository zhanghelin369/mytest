package com.itheima.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		
		ModelAndView mav = new ModelAndView();
		//判断异常类型
		if (e instanceof MyException) {
			//如果是自定义异常,读取异常信息
			MyException my = (MyException) e;
			mav.addObject("error",my.getMsg());
		}else{
			//如果是运行时异常
			mav.addObject("error","页面找不见了吆");
		}
		mav.setViewName("error");
		return mav;
	}
	
	
}
