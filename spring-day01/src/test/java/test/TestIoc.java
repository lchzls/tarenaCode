package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.Student;
import ioc.A;

public class TestIoc {
	@Test
	   public void test1(){
		   //����spring����
		   ApplicationContext ac = new ClassPathXmlApplicationContext("config/ioc.xml ");
		   //����������getBean��������ȡ����
		   A a = ac.getBean("a1",A.class);
		   a.execute();
		   
	   }
}
