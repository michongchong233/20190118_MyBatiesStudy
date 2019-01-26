package com.mickey.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.ibatis.session.SqlSession;

import com.mickey.util.T25_MyBatiesUtil;

/**
 * OpenSessionView�A�̶}�l�O��Spring�ج[���X���A��Xhibernate�ج[�ϥΪ��OOpenSessionInView
 */
@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "25_filter", value = "25_filter") })
public class T25_OpenSessionView implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SqlSession session = T25_MyBatiesUtil.getSqlSession();
		try {
			chain.doFilter(request, response);
		} catch (Exception e) {
			session.rollback();// �p�G�����~�h��^�_�l���A
			e.printStackTrace();
		} finally {
			T25_MyBatiesUtil.closeSession();
		}
	}
}
