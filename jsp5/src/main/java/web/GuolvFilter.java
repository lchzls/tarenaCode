package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GuolvFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("在前面过滤");
		chain.doFilter(req, res);
		System.out.println("在后面过滤");
	}

	//tomcat在创建Filter前，会给它创建一个config对象，
	//并调用此对象读取web.xml中预置的参数，然后在初始化Filter时将此config对象传入
	public void init(FilterConfig cfg) throws ServletException {

		System.out.println("初始化GuolvFilter");
		System.out.println(cfg.getInitParameter("city"));
	}

}
