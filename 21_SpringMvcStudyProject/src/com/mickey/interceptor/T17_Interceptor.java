package com.mickey.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class T17_Interceptor implements HandlerInterceptor {
	/*
	 * �b�i�J����e����A�Y��^�Ȭ�flase����i�J���
	 * ����N�X
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("do preHandle");
		System.out.println("handler: " + handler);
		return true;
	}

	/*
	 * �b������槹����A�i�Jjsp���e����
	 * ��x�O���B�ӷP���L�o
	 * �Y����L�{���X�{�[�`�h������
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
	 * jsp���槹�������
	 * �O������L�{�������`(��x)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("do afterCompletion");
		if(ex!=null)System.out.println("Exception: " + ex.getMessage());
	}
}
