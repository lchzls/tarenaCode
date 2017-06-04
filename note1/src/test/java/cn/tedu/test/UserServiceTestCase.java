package cn.tedu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.UserService;

public class UserServiceTestCase {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		
		ctx = new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	@Test
	public void testLogin(){
		
		UserService service = ctx.getBean("userService",UserService.class);
		User user = service.login("yongyong", "123");
		System.out.println(user);
	}
	
	
	@Test
	public void testRegist(){
		UserService service = ctx.getBean("userService",UserService.class);
		
		User user = service.regist("Jerry4", "Mouse", "123", "123");
	    System.out.println(user);
		
	}
	
	
}
