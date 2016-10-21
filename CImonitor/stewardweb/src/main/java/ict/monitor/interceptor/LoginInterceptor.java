package ict.monitor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ict.monitor.bean.User;
import ict.monitor.context.WebContext;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(WebContext.DEBUG) {
			User admin = new User();
			admin.setId(WebContext.DEBUG_USERID);
			admin.setUsername(WebContext.DEBUG_USERNAME);
			request.getSession().setAttribute("loged", true);
			request.getSession().setAttribute("userInfo", admin);
		}
		if(request.getServletPath().equals("/signUp.do")){
			return true;
		}
		HttpSession session = request.getSession(true);
		// 从session 里面获取用户名的信息
		Object obj = session.getAttribute("loged");
		// 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
		if (obj == null || "".equals(obj.toString())) {
			response.sendRedirect("login.do");
		}
		return true;
	}

}
