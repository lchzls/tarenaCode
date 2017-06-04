package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println(req.getContextPath()); // /servlet3
		System.out.println(req.getServletPath());// /hello
		System.out.println(req.getRequestURI());//   /servlet3/hello
		System.out.println(req.getRequestURL());// http://localhost:8088/servlet3/hello
		//������������д��Ӧ��Ϣ�������������Ӧʱʵ������Ϊ�ա�
		//��״̬�С���Ϣͷ��ֵ����ʱ����������Ľ���һƬ�հ� 
	}

}
