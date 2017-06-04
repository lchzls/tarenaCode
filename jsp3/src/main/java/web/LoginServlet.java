package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//���ղ���
		String code = req.getParameter("code");
		//���˺Ŵ���cookie
		//ÿ��cookieֻ�ܱ���һ�����ݣ��������ַ��� 
		Cookie c1 = new Cookie("code",code);
		//�޸�cookie����ʱ�䣬���䱣����Ӳ����
		c1.setMaxAge(60000); 
		
		c1.setPath("/jsp3");
		
		//��cookie�󶨵�request�ϣ�����Ӧʱ���������Զ����䷢�͸������
		res.addCookie(c1);
		
		//Cookie c2 = new Cookie("city","����");
		Cookie c2 = new Cookie("city",URLEncoder.encode("����", "utf-8"));
		res.addCookie(c2);

		
		Cookie c3 = new Cookie("city1",URLEncoder.encode("�Ϻ�", "utf-8"));
		res.addCookie(c3);
	}

}
