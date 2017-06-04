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
		 * 2.创建WEB项目servletbb，开发DateServlet，
		  向浏览器输出一个网页，内含一个段落，
		  段落中拼一个日期。
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
