package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * ���ڷ�װ�������ֵ���࣬Ҫ��
 * (1)��������ʵ�����������һ��
 * (2)�ṩ��Ӧ��get/set����
 * 
 */
public class AdminParam {

	private String adminCode;
	private String pwd;
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
}
