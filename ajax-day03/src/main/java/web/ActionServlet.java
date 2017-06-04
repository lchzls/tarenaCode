package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//分析请求资源路径，依据请求不同，调用
				//不同的分支来处理。
				String uri =
						request.getRequestURI();
				System.out.println("uri:" + uri);
				String action = 
					  uri.substring(
							  uri.lastIndexOf("/"),
							  uri.lastIndexOf("."));
				System.out.println("action:" + action);
				response.setContentType(
						"text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				if("/getFlights".equals(action)){
					String flight = request.getParameter("flight");
					System.out.println("flight:"+flight);
					if("CA1234".equals(flight)){
						out.println("头等舱:2400<br>商务舱:2200");
					}else{
						out.println("头等舱:1800<br>商务舱:1600");
					}
				}else if("/order".equals(action)){
					String addr = request.getParameter("addr");
					String uname = request.getParameter("uname");
					String phone = request.getParameter("phone");
					System.out.println(addr+" "+uname+" "+phone);
					out.println("<h2>保存成功</h2>");
				}
	}

}
