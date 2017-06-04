package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLogger {

	@Before("within(cn.tedu.note.service..*)")
	public void slogger(){
		System.out.println("进入Service方法");
	}
	
}
