package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomServlet extends HttpServlet {
/**
 * 1.����WEB��Ŀservletaa������RandomServlet��
  ����������һ����ҳ���ں�һ�����䣬
  ������ƴһ���������
 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//�����������ʲô��ʽ������
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int num = (int)(Math.random()*100);
		out.print("<p>"+num+"</p>");
		out.close();
	}
   
}
