package cn.tedu.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.service.NotebookService;

public class NotebookServiceTest {

	
ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		
		ctx = new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	
	@Test
	public void testListNotebooks(){
		
		String userId="ea09d9b1-ede7-4bd8-b43d-a546680df00b";
		NotebookService service = ctx.getBean("notebookService",NotebookService.class);
		List<Map<String,Object>> list =
				service.listNotebooks(userId);
		for(Map<String,Object> n:list){
			System.out.println(n);
		}
	}
}
