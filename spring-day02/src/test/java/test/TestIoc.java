package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Restaurant;
import ioc.A;

public class TestIoc {

	private ApplicationContext ac;//方便后面的测试方法调用ac
	
	@Before
	//@Before修饰的方法会在测试方法运行之前先执行
	public void init(){
		//启动Spring容器
		ac = new ClassPathXmlApplicationContext("autowire.xml");
	}
	
	@Test
	public void test1(){
		ac = new ClassPathXmlApplicationContext("ioc.xml");
		A a = ac.getBean("a1",A.class);
		a.execute();
	}
	

	@Test
	public void test2(){
		Restaurant rest = ac.getBean("rest",Restaurant.class);
		System.out.println(rest);
	}
}
