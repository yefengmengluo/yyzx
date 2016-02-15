/*package com.wangku.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionPlaceHolder implements Filter{
	 private static  ThreadLocal<HttpSession> SESSIONHOLDER=new ThreadLocal<HttpSession>();
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req=(HttpServletRequest)request;
			SESSIONHOLDER.set(req.getSession());
			chain.doFilter(request, response);
			SESSIONHOLDER.remove();
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	public static HttpSession getSession(){
		return SESSIONHOLDER.get();
	}

}
*/