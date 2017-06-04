package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	//tomcat启动时自动调用此方法，传入的是HttpServletResponse
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
      //将不需要过滤的路径排除掉
        String[] paths = new String[]{
        		"/toLogin.do","/createImg.do","/login.do"
        };
        //当前的路径
        String p = request.getServletPath();
        for(String path:paths){
        	if(p.equals(path)){
        		//1.若调用此方法则请求继续，交给下一个处理者(Filter/Servlet)
        		//2.若不调用此方法，则请求结束
        		chain.doFilter(req, res);
        		return;
        	}
        }
        
        //从session中获取账号
        HttpSession session =  request.getSession();
        Object adminCode = session.getAttribute("adminCode");
        System.out.println("adminCode"+adminCode);
        //根据账号判断用户是否登录
        if(adminCode==null){
        	//没登录，重定向到登录页面
        	response.sendRedirect("/netctoss/toLogin.do");
        }else{
        	//已登录，请求继续执行
        	chain.doFilter(req, res);
        }
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化LoginFilter");

	}

}
