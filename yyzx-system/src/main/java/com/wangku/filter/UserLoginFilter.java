package com.wangku.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class UserLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		   
		//设置请求响应字符编码  
	    response.setContentType("text/html ;charset=UTF-8");
	    request.setCharacterEncoding("UTF-8");
        //新增加的代码          
        HttpServletRequest req = (HttpServletRequest)request;  
          
     /*   if(req.getMethod().equalsIgnoreCase("get"))  
        {  
            req = new GetHttpServletRequestWrapper(req,"UTF-8");  
        }  */
      //  System.out.println("----请求被"+config.getFilterName()+"过滤");  
	    HttpSession session=req.getSession();
	    if(session.getAttribute("user")!=null){
	    	chain.doFilter(req, response);
	    }else{
	    	System.out.println("请重新的登录：=========");
	    	
	       /* HttpServletRequest re = (HttpServletRequest)request;
	        String path = re.getContextPath()+"/login.jsp";
	        HttpServletResponse res=(HttpServletResponse)response;
	        res.sendRedirect(path);*/
	        java.io.PrintWriter out = response.getWriter();   
	        out.println("<html>");   
	        out.println("<script>");  
	        HttpServletRequest re = (HttpServletRequest)request;
	        String path = re.getContextPath()+"/login.jsp";
	        out.println("window.open ('"+path+"','_top')");   
	       
	        out.println("</script>");   
	        out.println("</html>");
	   }
	}

	@Override
	public void destroy() {
		
	}
	

}
