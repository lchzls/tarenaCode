package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  //��ʾ��NoteLogger����Ϊ�������
public class NoteLogger {

	//��ʾ��cn.tedu.note.web�������Ӱ��£������������֮ǰ�������������ķ���clogger()
	@Before("within(cn.tedu.note.web..*)")
	public void clogger(){
		System.out.println("����Controller����");
	}	
}
