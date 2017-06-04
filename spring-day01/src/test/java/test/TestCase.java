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
 * ����һ��������
 * 1.���Է���ǰ���@Testע��
 * @author Administrator
 *
 */
public class TestCase {
   @Test
   public void test1(){
	   //����spring����
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml ");
	   //����������getBean��������ȡ����
	   Student stu1 = ac.getBean("stu1",Student.class);
	   System.out.println(stu1);
	   Date date1 = ac.getBean("date1",Date.class);
	   System.out.println(date1);
   }
   
   @Test
   public void test2(){
	   //��������
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   Calendar cal1 = ac.getBean("cal1",Calendar.class);
	   System.out.println(cal1);
   }
   
   @Test
   public void test3(){
	  //��������
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   Date time1 = ac.getBean("time1",Date.class);
	   System.out.println(time1);
   }
   
   @Test
   public void test4(){
	  //��������
	   AbstractApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   ExampleBean eb1 = ac.getBean("eb1",ExampleBean.class);
	   eb1.sendMessage();
	   //�ر�����
	   ac.close();
	   
   }
   
   //����������
   @Test
   public void test5(){
	  //��������
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	   ExampleBean eb1 = ac.getBean("eb1",ExampleBean.class);
	   ExampleBean eb2 = ac.getBean("eb1",ExampleBean.class);
	   System.out.println(eb1==eb2);  

   }
   
   
   @Test
   public void test6(){
	  //��������
	   ApplicationContext ac = new ClassPathXmlApplicationContext("config/basic.xml");
	    
   }
   
   
}
