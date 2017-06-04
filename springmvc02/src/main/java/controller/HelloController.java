package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/** 
 * ��������
 * 1.����ʵ��Controller�ӿ�
 * 2.������Ӷ������
 * 3.����������Ҫ�󣬷���ֵ������ModelAndView��Ҳ������String��
 * 4.������ǰ���@Controller
 * 5.ʹ��@RequestMapping������DispatcherServlet������·���봦�����Ķ�Ӧ��ϵ
 */

@Controller
public class HelloController {
	// http://localhost:8080/springmvc02/hello.do
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String checkLogin1(HttpServletRequest request){
		System.out.println("checkLogin1()");
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+",pwd="+pwd);
		return "index";
	}
	
	/**
	 * ��ȡ�������ֵ�ĵڶ��ַ�ʽ��ʹ��
	 *@RequestParam(String param),param��ʵ�����������
	 *ע�����飬��ʹʵ��������������β���һ�£�ҲҪ���@RequestParam����˵��
	 */
	@RequestMapping("/login2.do")
	public String checkLogin2(@RequestParam("adminCode") String adminCode,@RequestParam("pwd") String password){
		System.out.println("checkLogin2()");
		System.out.println("adminCode:"+adminCode+",pwd="+password);
		return "index";
	}
	
	/*
	 * ��ȡ�������ֵ�ĵ����ַ�ʽ
	 * ��װ��һ��javabean
	 */
	@RequestMapping("/login3.do")
	public String checkLogin3(AdminParam ap){
		System.out.println("checkLogin3()");
		System.out.println("adminCode:"+ap.getAdminCode());
		return "index";
	}
	
	/*
	 * ��ҳ�洫ֵ�ĵ�һ�ַ�ʽ��ʹ��request����
	 */
	@RequestMapping("/login4.do")
	public String checkLogin4(AdminParam ap,HttpServletRequest request){
		System.out.println("checkLogin4()");
		request.setAttribute("adminCode", ap.getAdminCode());
		//Ĭ��ʹ��ת��
		return "index";
	}
	
	/*
	 * ��ҳ�洫ֵ�ĵڶ��ַ�ʽ
	 * ͨ��session��ʽ
	 */
	@RequestMapping("/login5.do")
	public String checkLogin5(AdminParam ap,HttpSession session){
		System.out.println("checkLogin5()");
		session.setAttribute("adminCode", ap.getAdminCode());
		//Ĭ��ʹ��ת��
		return "index";
	}
	
	/*
	 * ��ҳ�洫ֵ�ĵ����ַ�ʽ
	 * ����ͨ��ModelMap
	 */
	@RequestMapping("/login6.do")
	public String checkLogin6(AdminParam ap,ModelMap mm){
		System.out.println("checkLogin6()");
		//�൱�ڰ󶨵���request����,����"adminCode"
		mm.addAttribute("adminCode", ap.getAdminCode());
		return "index";
	}
	
	
	/*
	 * ��ҳ�洫ֵ�ĵ����ַ�ʽ
	 * ͨ��ModelAndView����
	 */
	@RequestMapping("/login7.do")
	public ModelAndView checkLogin7(AdminParam ap){
		System.out.println("checkLogin7()");
		//���������ȷŵ�Map����
		Map<String,Object> data = new HashMap<String,Object>();
		//�൱�ڽ����ݰ󶨵�request
		data.put("adminCode", ap.getAdminCode());
		ModelAndView mav = new ModelAndView("index",data);
		return mav;
	}
	
	//�ض���ĵ�һ�ַ�ʽ
	@RequestMapping("/login8.do")
	public String checkLogin8(){
		System.out.println("checkLogin8()");
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/login9.do")
	public ModelAndView checkLogin9(){
		System.out.println("checkLogin9()");
		RedirectView rv = new RedirectView("toIndex.do");
		return new ModelAndView(rv);
		
	}
}
