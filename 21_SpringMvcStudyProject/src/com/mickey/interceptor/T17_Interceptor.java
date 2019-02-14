package com.mickey.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class T17_Interceptor implements HandlerInterceptor {
	/*
	 * 在進入控制器前執行，若返回值為flase阻止進入控制器
	 * 控制代碼
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("do preHandle");
		System.out.println("handler: " + handler);
		return true;
	}

	/*
	 * 在控制器執行完成後，進入jsp之前執行
	 * 日誌記錄、敏感詞過濾
	 * 若執行過程中出現茉常則不執行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("do postHandle");
		System.out.println("ModelAndView: " + modelAndView.getViewName());
		System.out.println("modelValue: " + modelAndView.getModel().get("model"));
		modelAndView.getModel().put("model", "update model value");
		System.out.println("modelValue: " + modelAndView.getModel().get("model"));
	}

	/*
	 * jsp執行完成後執行
	 * 記錄執行過程中的異常(日誌)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("do afterCompletion");
		if(ex!=null)System.out.println("Exception: " + ex.getMessage());
	}
}
