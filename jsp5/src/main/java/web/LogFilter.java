package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {

	//�ر�tomcatʱ�����Զ����ô˷���������Filter
	public void destroy() {
	System.out.println("����LogFilter");

	}

	//tomcat�ڴ�������ǰ�Զ����ô˷���������request��response���롣
	//ʵ����tomcat�ǽ�����Ĵ���Ȩ��ȫ����������������������������������
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	System.out.println("��ǰ�����־");
    //1.�����ô˷��������������������һ��������(Filter/Servlet)
	//2.�������ô˷��������������
	chain.doFilter(req, res);
    System.out.println("�ں������־");
	}

	//tomcat������ʱ���Զ�ʵ����Filter�����Զ�����init()��ʼ��Filter
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��LogFilter");

	}

}
