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
		System.out.println("��ǰ�����");
		chain.doFilter(req, res);
		System.out.println("�ں������");
	}

	//tomcat�ڴ���Filterǰ�����������һ��config����
	//�����ô˶����ȡweb.xml��Ԥ�õĲ�����Ȼ���ڳ�ʼ��Filterʱ����config������
	public void init(FilterConfig cfg) throws ServletException {

		System.out.println("��ʼ��GuolvFilter");
		System.out.println(cfg.getInitParameter("city"));
	}

}
