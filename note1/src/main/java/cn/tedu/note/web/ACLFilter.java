package cn.tedu.note.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.tedu.note.service.UserService;

public class ACLFilter implements Filter {

	private ServletContext sc;
	private ApplicationContext ctx;
	private UserService userService;
	
	
	public void init(FilterConfig cfg) throws ServletException {
		
		sc = cfg.getServletContext();
		//传入参数servletContext，调用WebApplicationContextUtils的
		//getWebApplicationContext(sc)来获取Spring容器
		ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		//从容器中获取UserService对象
		userService = ctx.getBean("userService",UserService.class);

	}
	


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String path = request.getRequestURI();
		//System.out.println("path:"+path);
		
		path = path.substring(path.indexOf('/',1));
		//System.out.println("trim path:"+path);
		
		//path:/note1/user/login.do
	   //trim path:/user/login.do
		
		//注意，此时的path是除了项目名后的路径，即最直白的controller中访问的路径，如/user/login.do
		
		//如果用户直接访问edit.html，则若未登录，重定向到login_in.html
		if(path.matches(".*/edit\\.html$")){
			checkLogin(request,response,chain);
			return;
		}
		
		/*
		 * 面试题：如果保证单用户登录？
		 * 如果用户访问/note/*.do或者/notebook/*.do，为什么要这样做，因为若同时打开两个浏览器，
		 * 第一次都可以登录进入，因为log_in.html访问路径都不满足这两个条件，也就是保证用户第一次登录
		 * 若账号密码正确是一定能登录进去的，但是，两个浏览器同时打开，那么两个浏览器都可以同时登录同一个用户的
		 * 账号，此时，如果后登录的浏览器进入edit.html时，由于登录时会自动生成token并且写入user表，同时
		 * 将这个token发送给了浏览器，因此，只需要去读取当前浏览器的token与user表中的token是否一致。
		 * 第一个浏览器登录，则数据库中存的是token1，并且发送给浏览器。第二个浏览器登录同一个账号，则数据库中
		 * 存的是token2了，同时发送给第二个浏览器。所以，当第一个用户再次点击/note/*.do或者/notebook/*.do
		 * 时，由于数据库中的token已经发生改变，和当前浏览器的token不一致，因此，过滤器不会让其通过，从而返回
		 * JSON错误信息，提示必须登录。
		 * 
		 */
		if(path.matches(".(note).*\\.do$")){
			checkDotDo(request,response,chain);
			return;
		}
		
		
		chain.doFilter(request, response);

	}

	private void checkDotDo(HttpServletRequest request,HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException{
		//System.out.println("checkDotDo");
		String token = getCookie(request,"token");
		String userId = getCookie(request,"userId");
		System.out.println(userId+"-----"+token);
		
		if(userService.checkToken(userId, token)){
			chain.doFilter(request, response);
			return;
		}
		
		//没有登录的时候，返回JSON错误消息
		String json = "{\"state:\":1,\"message\":\"必须登录!\"}";
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(json);
		
	}
	
	//查找某一个cookie
	private String getCookie(HttpServletRequest request, 
			String cookieName) {
		Cookie[] cookies=request.getCookies();
		//如果客户端没有cookie，就会返回null
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookieName.equals(
						cookie.getName())){
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		//System.out.println("checkLogin");
		//检查是否有 token cookie 
		//如果没有， 就重定向到log_in.html
		String token = getCookie(request, "token");
		String userId= getCookie(request,"userId");
		//System.out.println("userId:"+userId); 
		if(userService.checkToken(userId, token)){
			chain.doFilter(request, response);
			return;
		}
		//重定向到 log_in.html
		String path=request.getContextPath()+
			"/log_in.html";
		response.sendRedirect(path);
	}
	
	public void destroy() {


	}

}

