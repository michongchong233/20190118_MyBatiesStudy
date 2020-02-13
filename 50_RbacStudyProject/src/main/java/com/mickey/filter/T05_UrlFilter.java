package com.mickey.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mickey.pojo.T03_User;
import com.mickey.pojo.T05_Url;

@WebFilter("/*")
public class T05_UrlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		// 若是以下文件格式則直接放行
		if (uri.endsWith(".js") || uri.endsWith(".caa") || uri.endsWith(".html") || uri.endsWith(".jpg")
				|| uri.endsWith(".png") || uri.endsWith(".gif")) {
			chain.doFilter(req, response);
		} else {
			if (uri.equals("/50_RbacStudyProject/login_03") || uri.equals("/50_RbacStudyProject/t03_login.jsp")) {
				chain.doFilter(req, response);
			} else {
				HttpSession session = req.getSession();
				// 登入驗證
				T03_User user = (T03_User)session.getAttribute("user");
				if (user != null) {
					// 已經登入
					List<T05_Url> urlList = (List<T05_Url>) session.getAttribute("allUrl");
					boolean isExist = false;
					// 此url是否需要被驗證
					for (T05_Url url : urlList) {
						if (url.getUrlPath().equals(uri)) {
							isExist = true;
						}
					}
					if (isExist) {
						// 如果此url需要被權限空制
						boolean isRight = false;
						for (T05_Url url : user.getUrls()) {
							if (url.getUrlPath().equals(uri)) {
								System.out.println("isRight = true");
								isRight = true;
							}
						}
						if (isRight) {
							//如果此用戶有權限訪問此url
							chain.doFilter(req, response);
						}else {
							//如果此用戶沒有權限訪問此url
							session.removeAttribute("user");
							session.removeAttribute("allUrl");
							((HttpServletResponse) response).sendRedirect("/50_RbacStudyProject/t03_error.jsp");
						}
					} else {
						// 如果此url不需要被權限控制
						chain.doFilter(req, response);
					}
				} else {
					// 沒有登入
					((HttpServletResponse) response).sendRedirect("/50_RbacStudyProject/t03_login.jsp");
				}
			}
		}

	}

	@Override
	public void destroy() {
	}

}
