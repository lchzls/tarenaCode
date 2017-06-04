package cn.tedu.demo;

import java.util.Date;

public class Demo08 {

	public static void main(String[] args) 
		throws Exception{
		ApplicationContext ctx =
			new ApplicationContext(
			"spring.xml");
		Date d = (Date)ctx.getBean("date");
		System.out.println(d); 
		Goo goo = (Goo)ctx.getBean("goo");
		System.out.println(goo); 
	}

}
