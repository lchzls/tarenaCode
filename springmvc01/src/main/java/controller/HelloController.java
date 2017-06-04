package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	public HelloController() {
		
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("HelloController's handleRequest()");
		//����һ��ModelAndView����
		/*ModelAndView������������
		 * ��һ��
		 * ModelAndView(String viewName)��viewName����ͼ��
		 * �ڶ���
		 * ModelAndView(String viewName,Map data)��data�Ǵ�����
		 * 
		 */
		
		return new ModelAndView("hello");
	}

}
