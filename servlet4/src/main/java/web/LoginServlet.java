package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	
	
	//tomcat�ڴ�����Servletǰ�������������һ��config���󣬸ö���ֻ����Servlet�Լ�ʹ�ã�����Server�޷����ʣ�����Servlet�޷����ʡ�
	//�����ڵ��ô�Servlet��init()ʱ�������config�����롣config��tomcat�������Զ���ȡ��web.xml�еĲ�����
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String maxOnline = config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//1.���մ�����˺�����
		System.out.println("���մ�����˺�����");
		//2.��֤�˺������Ƿ���ȷ
		System.out.println("��֤�˺������Ƿ���ȷ");
		//3.�жϵ�ǰ��������
		ServletConfig config = getServletConfig();
		String maxOnline = config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
		//4.������Ϸ���Ŷ�
		System.out.println("������Ϸ");
		
		
		//ͳ����վ����
		ServletContext ctx = 
			getServletContext();
		Integer count = (Integer)
			ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}

}
