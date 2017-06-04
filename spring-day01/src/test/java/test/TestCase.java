package test;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.ExampleBean;
import basic.Student;

/**
 * 这是一个测试类
 * 1.测试方法前添加@Test注解
 * @author Administrator
 *
 */
public class TestCase {
   @Test
   public void test1(){
	   //启动spring容器
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml ");
	   //调用容器的getBean方法来获取对象
	   Student stu1 = ac.getBean("stu1",Student.class);
	   System.out.println(stu1);
	   Date date1 = ac.getBean("date1",Date.class);
	   System.out.println(date1);
   }
   
   @Test
   public void test2(){
	   //启动容器
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   Calendar cal1 = ac.getBean("cal1",Calendar.class);
	   System.out.println(cal1);
   }
   
   @Test
   public void test3(){
	  //启动容器
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   Date time1 = ac.getBean("time1",Date.class);
	   System.out.println(time1);
   }
   
   @Test
   public void test4(){
	  //启动容器
	   AbstractApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   ExampleBean eb1 = ac.getBean("eb1",ExampleBean.class);
	   eb1.sendMessage();
	   //关闭容器
	   ac.close();
	   
   }
   
   //测试作用域
   @Test
   public void test5(){
	  //启动容器
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   ExampleBean eb1 = ac.getBean("eb1",ExampleBean.class);
	   ExampleBean eb2 = ac.getBean("eb1",ExampleBean.class);
	   System.out.println(eb1==eb2);  

   }
   
   
   @Test
   public void test6(){
	  //启动容器
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	    
   }
   
   
}
