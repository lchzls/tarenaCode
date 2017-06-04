package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	
	
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		//1.ʹ��request��ȡ��������
				//1.1��ȡ������
				System.out.println(
					"����ʽ:" + req.getMethod()); //����ʽ:GET
				System.out.println(
					"����·��:" + req.getServletPath()); //����·��:/ts
				System.out.println(
					"Э������:" + req.getProtocol()); //Э������:HTTP/1.1
				//1.2��ȡ��Ϣͷ
				//getHeaderNames()����key�ĵ�������
				//�õ������Ǳ�Iterator�����ϵĵ�������
				Enumeration e = req.getHeaderNames();
				while(e.hasMoreElements()) {
					String key = (String) e.nextElement();
					String value = req.getHeader(key);
					System.out.println(
						key + ":" + value); 
					//host:localhost:8088 
					//connection:keep-alive��
				}
				//1.3��ȡʵ������
				//�����������û��������������κ�ҵ�����ݣ�
				//����ʵ������Ϊ�ա�
				
				//2.ʹ��responseд��Ӧ����
				//2.1д״̬�У��ɷ������Զ�д
				//2.2д��Ϣͷ
				//��������������������ʲô��ʽ������
				res.setContentType("text/html");
				//��ȡ�����������ָ���Ŀ����������
				PrintWriter out = res.getWriter();
				//�˴�͵��ʡ�Դ���N��
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				String now = sdf.format(date);
				out.println("<p>"+now+"</p>");
				out.close();
	}
}
