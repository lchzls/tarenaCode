package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	//tomcat����ʱ�Զ����ô˷������������HttpServletResponse
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
      //������Ҫ���˵�·���ų���
        String[] paths = new String[]{
        		"/toLogin.do","/createImg.do","/login.do"
        };
        //��ǰ��·��
        String p = request.getServletPath();
        for(String path:paths){
        	if(p.equals(path)){
        		//1.�����ô˷��������������������һ��������(Filter/Servlet)
        		//2.�������ô˷��������������
        		chain.doFilter(req, res);
        		return;
        	}
        }
        
        //��session�л�ȡ�˺�
        HttpSession session =  request.getSession();
        Object adminCode = session.getAttribute("adminCode");
        System.out.println("adminCode"+adminCode);
        //�����˺��ж��û��Ƿ��¼
        if(adminCode==null){
        	//û��¼���ض��򵽵�¼ҳ��
        	response.sendRedirect("/netctoss/toLogin.do");
        }else{
        	//�ѵ�¼���������ִ��
        	chain.doFilter(req, res);
        }
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��LoginFilter");

	}

}
