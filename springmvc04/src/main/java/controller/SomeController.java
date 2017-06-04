package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SomeController {

	
	/*
	 * ����һ���쳣���������������������������׳����쳣��
	 * ex�������������׳����쳣
	 */
	@ExceptionHandler
	public String handler(Exception ex,HttpServletRequest request){
		System.out.println("handler()");
		//�����쳣���ͣ��ֱ�����ͬ�Ĵ���
		if(ex instanceof NumberFormatException){
			request.setAttribute("errorMsg", "�ף���������ȷ������");
			return "error1";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			request.setAttribute("errorMsg", "����Խ��");
			return "error2";
		}else{
			//�����쳣����ʾ�û��Ժ�����
			return "error3";
		}
		

	}
	
	
	@RequestMapping("/hello.do")
	public String hello1(HttpServletRequest request){
		System.out.println("hello1()");
		String number = request.getParameter("number");
		number.charAt(10);
		Integer.parseInt(number);
		return "hello";
	}
}


