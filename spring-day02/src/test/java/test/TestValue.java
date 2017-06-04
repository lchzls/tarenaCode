package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.A;
import value.ExampleBean;
import value.SpelBean;

public class TestValue {

	private ApplicationContext ac;
	
	@Before
	//@Before修饰的方法会在测试方法运行之前先执行
	public void init(){
		//启动Spring容器
		ac = new ClassPathXmlApplicationContext("value.xml");
	}
	
	@Test
	public void test1(){
		ExampleBean eb1 = ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb1);
	}
	
	@Test
	public void test2(){
		ExampleBean eb2 = ac.getBean("eb2",ExampleBean.class);
		System.out.println(eb2);
	}
	
	@Test
	public void test3(){
		System.out.println(ac.getBean("config"));
	}
	
	@Test
	public void test4(){
		SpelBean sb1 = ac.getBean("sb1",SpelBean.class);
		System.out.println(sb1);
	}

}
