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
		//�������servletContext������WebApplicationContextUtils��
		//getWebApplicationContext(sc)����ȡSpring����
		ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
		//�������л�ȡUserService����
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
		
		//ע�⣬��ʱ��path�ǳ�����Ŀ�����·��������ֱ�׵�controller�з��ʵ�·������/user/login.do
		
		//����û�ֱ�ӷ���edit.html������δ��¼���ض���login_in.html
		if(path.matches(".*/edit\\.html$")){
			checkLogin(request,response,chain);
			return;
		}
		
		/*
		 * �����⣺�����֤���û���¼��
		 * ����û�����/note/*.do����/notebook/*.do��ΪʲôҪ����������Ϊ��ͬʱ�������������
		 * ��һ�ζ����Ե�¼���룬��Ϊlog_in.html����·����������������������Ҳ���Ǳ�֤�û���һ�ε�¼
		 * ���˺�������ȷ��һ���ܵ�¼��ȥ�ģ����ǣ����������ͬʱ�򿪣���ô���������������ͬʱ��¼ͬһ���û���
		 * �˺ţ���ʱ��������¼�����������edit.htmlʱ�����ڵ�¼ʱ���Զ�����token����д��user��ͬʱ
		 * �����token���͸������������ˣ�ֻ��Ҫȥ��ȡ��ǰ�������token��user���е�token�Ƿ�һ�¡�
		 * ��һ���������¼�������ݿ��д����token1�����ҷ��͸���������ڶ����������¼ͬһ���˺ţ������ݿ���
		 * �����token2�ˣ�ͬʱ���͸��ڶ�������������ԣ�����һ���û��ٴε��/note/*.do����/notebook/*.do
		 * ʱ���������ݿ��е�token�Ѿ������ı䣬�͵�ǰ�������token��һ�£���ˣ���������������ͨ�����Ӷ�����
		 * JSON������Ϣ����ʾ�����¼��
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
		
		//û�е�¼��ʱ�򣬷���JSON������Ϣ
		String json = "{\"state:\":1,\"message\":\"�����¼!\"}";
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(json);
		
	}
	
	//����ĳһ��cookie
	private String getCookie(HttpServletRequest request, 
			String cookieName) {
		Cookie[] cookies=request.getCookies();
		//����ͻ���û��cookie���ͻ᷵��null
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
		//����Ƿ��� token cookie 
		//���û�У� ���ض���log_in.html
		String token = getCookie(request, "token");
		String userId= getCookie(request,"userId");
		//System.out.println("userId:"+userId); 
		if(userService.checkToken(userId, token)){
			chain.doFilter(request, response);
			return;
		}
		//�ض��� log_in.html
		String path=request.getContextPath()+
			"/log_in.html";
		response.sendRedirect(path);
	}
	
	public void destroy() {


	}

}

