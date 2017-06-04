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
		//����������Դ·������������ͬ������
				//��ͬ�ķ�֧������
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
						out.println("ͷ�Ȳ�:2400<br>�����:2200");
					}else{
						out.println("ͷ�Ȳ�:1800<br>�����:1600");
					}
				}else if("/order".equals(action)){
					String addr = request.getParameter("addr");
					String uname = request.getParameter("uname");
					String phone = request.getParameter("phone");
					System.out.println(addr+" "+uname+" "+phone);
					out.println("<h2>����ɹ�</h2>");
				}
	}

}
