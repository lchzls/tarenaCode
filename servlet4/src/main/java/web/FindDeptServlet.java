package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet {

	//tomcat����ʱ�Ѿ�������context����ʹ������ȡ��web.xml�еĲ�����
	//�û����ʴ˲�ѯ����ʱ�Ϳ��Դ�context���ȡ���������
	@Override
	protected void service(HttpServletRequest res, HttpServletResponse req) 
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		String size = context.getInitParameter("size");
		System.out.println(size);
		System.out.println("��ҳ��ѯ����");
		
		
		//ͳ����վ����
		ServletContext ctx = 
			getServletContext();
		Integer count = (Integer)
			ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		System.out.println(count);
	}
 
}
