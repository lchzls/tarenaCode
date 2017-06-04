package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
   
	//1.Ĭ���״η���ʱʵ����
	//2.�޸����ú�������tomcatʱʵ����
	public HiServlet(){
		System.out.println("ʵ����Servlet");
	}

	//��ʵ����servlet����tomcat�Զ����ã�����һ��
	//��д�����init(ServletConfig arg0)����  
	//source->Override->GenericServlet->init(ServletConfig arg0)
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("��ʼ��Servlet");
	}

	//ÿ�η��ʶ����Ե��ã���д��������
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("����HiServlet");
	}
    
	//�����ر�tomcatʱ��������
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("����HiServlet");
	}
	
	
	
	
}
