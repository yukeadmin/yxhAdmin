package com.yxh.filiter;

import java.io.IOException;
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

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter implements Filter {

	public MyFilter() {

	}

	public void destroy() {
//		System.out.println("MyFilter销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//获取当前访问的地址
		String requestURL = req.getRequestURI();//getRequestURI().toLowerCase();
		//判断页面类型，如果是配置文件或是样式文件则放行,如果是JSP界面则进行过滤
//		if((requestURL.contains(".js") || requestURL.contains(".css")||requestURL.contains(".less"))){
//			chain.doFilter(req, resp);
//		}
		if(!requestURL.contains(".jsp")){
			chain.doFilter(req, resp);
		}else if(requestURL.contains(".jsp")){
			// 先判断是不是请求的登陆（注册、忘记密码）页面，如果是的话不做任何处理，不是的话再去过滤
			if (requestURL.indexOf("login.jsp") == -1){
				HttpSession session = req.getSession();
				// 从session中获取loginUser属性
				String isLogin = (String) session.getAttribute("isLogin");
				// 判断属性是否为空 
				if ("".equals(isLogin) || null == isLogin) {
					session.setAttribute("loginmsg", "您还没有登陆，请登陆之后访问");
					resp.sendRedirect("/yxhAdmin/login.jsp");
					return;
				}
			}
			// 如果为空，重定向到login.jsp
			// 不为空就放行喽
			chain.doFilter(req, resp);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
