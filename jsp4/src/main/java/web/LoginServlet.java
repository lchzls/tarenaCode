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
		//ÿ��������״η��ʷ�����ʱ�������������������1��session������session����request(��ַ)
		HttpSession session = req.getSession();  //ctrl+1�����Զ���ʾ��Ҫ�����jar��
		//session����洢�ڷ��������ڴ�����ԣ�session�п��Ա����������͵�����
		session.setAttribute("code", code);
		//���ڱ��η��ʴ������µ�session�����Է���������Ӧʱ���Զ��Ľ�sessionId����cookie������cookie���͸������
	
	}

}
