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
		pointcut="within(cn.tedu.note.web..*)") //这里的ex要和参数名一致，表示只要切入的组件中抛出异常，将这个异常传给方法中的ex
	//怎么获取异常对象呢？在方法中加一个参数Exception
	public void log(Exception ex){
		//将异常信息写入文件
		System.out.println("记录异常信息:"+ex);
		try {
			FileWriter fw = new FileWriter("D:\\error.txt");
			PrintWriter out = new PrintWriter(fw);
			ex.printStackTrace(out);//指定异常信息往输出流中去写入，而输出流最后是写入到error.txt
			out.flush();
			out.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("记录异常信息失败");
		}
	}
}
