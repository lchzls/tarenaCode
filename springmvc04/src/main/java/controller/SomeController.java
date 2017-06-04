package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SomeController {

	
	/*
	 * 这是一个异常处理方法，用来处理其他方法所抛出的异常。
	 * ex：其他方法所抛出的异常
	 */
	@ExceptionHandler
	public String handler(Exception ex,HttpServletRequest request){
		System.out.println("handler()");
		//依据异常类型，分别做不同的处理
		if(ex instanceof NumberFormatException){
			request.setAttribute("errorMsg", "亲，请输入正确的数字");
			return "error1";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			request.setAttribute("errorMsg", "数组越界");
			return "error2";
		}else{
			//其他异常，提示用户稍后重试
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


