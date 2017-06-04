package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//分析请求路径，依据请求不同，调用不同的分支来处理。
		//比如/ajax-day01/abc.do
		String uri = req.getRequestURI();
		System.out.println("uri:"+uri);
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:"+action);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		if("/check_uname".equals(action)){
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			System.out.println("username:"+username);
			if("Sally".equals(username)){
				out.println("用户名被占用");
			}else{
				out.println("可以使用");
			}
		}else if("/random".equals(action)){
			Random number = new Random();
			int r = number.nextInt(100);
			out.println(r);
		}
		
	}

}
