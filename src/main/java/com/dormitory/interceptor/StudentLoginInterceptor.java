package com.dormitory.interceptor;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 登录认证的拦截器
 * 
 * @author guo.junbao
 * @date 2017-5-11
 *
 */
public class StudentLoginInterceptor implements HandlerInterceptor {
	/**
	 * Handler执行完成之后调用这个方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		// if(backUrl!=null&&(backUrl.isEmpty()==false)){
		// String url=request.getRequestURI();
		// response.sendRedirect(url+"?backUrl="+backUrl);
		// System.out.println("redirect to "+backUrl);
		// }
		System.out.println("postHandle");
	}

	/**
	 * Handler执行之前调用这个方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		
		Map<String, String[]> list = request.getParameterMap();
		Iterator<Entry<String, String[]>> it = list.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String[]> item = it.next();
			System.out.println(item.getKey() + " " + item.getValue()[0]);
		}
		System.out.println("url=" + url);
		
		// URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
		if (url.contains("studentLogin.do")) {
			return true;
		}
		// 获取Session
		HttpSession session = request.getSession();
		Long studentId = (Long) session.getAttribute("studentId");
		System.out.println("studentId: " + studentId);
		if (studentId != null) {
			return true;
		}
		// 不符合条件的，跳转到登录页
		// response.sendRedirect("index.jsp");
		
		response.sendRedirect("/dormitory/login.jsp");
		System.out.println("redirect to login.jsp");
		// mv=new ModelAndView("redirect:/login/login.do",null);
		return false;
	}

}
