package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Manager;
import annotation.MessageBean;
import annotation.Restaurant;
import annotation.School;
import annotation.WinBar;

public class TestCase {

	@Test
	public void test1(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
		System.out.println("-------------");
		MessageBean mb1 = ac.getBean("mb1",MessageBean.class);
		mb1.sendMsg();
	    ac.close();
	}

	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
		MessageBean mb1 = ac.getBean("mb1",MessageBean.class);
		MessageBean mb2 = ac.getBean("mb1",MessageBean.class);
		System.out.println(mb1==mb2);
	}
	
	@Test
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
	}
	
	@Test
	public void test4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
		Restaurant rest = ac.getBean("rest",Restaurant.class);
		System.out.println(rest);
		School school = ac.getBean("school",School.class);
		System.out.println(school);
	}
	
	@Test
	public void test5(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
		WinBar wb1 = ac.getBean("wb1",WinBar.class);
		System.out.println(wb1);
	}
	
	//����@Value
	@Test
	public void test6(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
		Manager mg1 = ac.getBean("mg1",Manager.class);
		System.out.println(mg1);
	}
	
	
	
}
