package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//��ȡ��������
		String code = req.getParameter("code");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] interests = req.getParameterValues("interest");
		
		//������������
//	    byte[] bs = code.getBytes("iso8859-1");
//	    code =new String(bs,"utf-8");
	    
	
		//������Щ����
		System.out.println(code);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests!=null){
			for(String i : interests){
				System.out.println(i);
			}
		}
		//�����Ӧ��Ϣ
		res.setContentType("text/html;charset=utf-8");
	//	res.setCharacterEncoding("utf-8"); ��һ����Բ�д��ʵ�ʿ�����ֻҪд������һ�伴�ɡ�
		PrintWriter out = res.getWriter();
		out.print("<p>ע��ɹ�</p>");
		out.close();
		
	}
  
}
