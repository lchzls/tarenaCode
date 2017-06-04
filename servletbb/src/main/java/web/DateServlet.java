package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		/*
		 * 2.����WEB��Ŀservletbb������DateServlet��
		  ����������һ����ҳ���ں�һ�����䣬
		  ������ƴһ�����ڡ�
		 */
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(date);
		out.print("<p>"+time+"</p>");
		out.close();
	}
 
}
