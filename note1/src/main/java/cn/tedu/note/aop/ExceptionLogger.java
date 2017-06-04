package cn.tedu.note.aop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect 
public class ExceptionLogger {
	
	@AfterThrowing(throwing="ex",
		pointcut="within(cn.tedu.note.web..*)") //�����exҪ�Ͳ�����һ�£���ʾֻҪ�����������׳��쳣��������쳣���������е�ex
	//��ô��ȡ�쳣�����أ��ڷ����м�һ������Exception
	public void log(Exception ex){
		//���쳣��Ϣд���ļ�
		System.out.println("��¼�쳣��Ϣ:"+ex);
		try {
			FileWriter fw = new FileWriter("D:\\error.txt");
			PrintWriter out = new PrintWriter(fw);
			ex.printStackTrace(out);//ָ���쳣��Ϣ���������ȥд�룬������������д�뵽error.txt
			out.flush();
			out.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("��¼�쳣��Ϣʧ��");
		}
	}
}
