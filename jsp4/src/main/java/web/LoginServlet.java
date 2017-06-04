package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String code = req.getParameter("code");
		//每个浏览器首次访问服务器时，服务器都会给它创建1个session，并将session存入request(地址)
		HttpSession session = req.getSession();  //ctrl+1可以自动显示出要导入的jar包
		//session对象存储在服务器的内存里，所以，session中可以保存任意类型的数据
		session.setAttribute("code", code);
		//由于本次访问创建了新的session，所以服务器在响应时会自动的将sessionId存入cookie，并将cookie发送给浏览器
	
	}

}
