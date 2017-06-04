package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  //表示将NoteLogger定义为切面组件
public class NoteLogger {

	//表示在cn.tedu.note.web包及其子包下，多个方法调用之前，调用这个切面的方法clogger()
	@Before("within(cn.tedu.note.web..*)")
	public void clogger(){
		System.out.println("进入Controller处理");
	}	
}
