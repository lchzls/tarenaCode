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
 * 1.创建WEB项目servletaa，开发RandomServlet，
  向浏览器输出一个网页，内含一个段落，
  段落中拼一个随机数。
 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//设置输出的是什么格式的内容
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int num = (int)(Math.random()*100);
		out.print("<p>"+num+"</p>");
		out.close();
	}
   
}
