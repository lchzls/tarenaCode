package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Restaurant;
import ioc.A;

public class TestIoc {

	private ApplicationContext ac;//�������Ĳ��Է�������ac
	
	@Before
	//@Before���εķ������ڲ��Է�������֮ǰ��ִ��
	public void init(){
		//����Spring����
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
