package cn.tedu.test;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteService;

public class NoteServiceTestCase {

ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		
		ctx = new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
	}
	
	
	@Test
	public void testListNotes(){
		String notebookId = "d0b0727f-a233-4a1f-8600-f49fc1f25bc9";
		NoteService service = ctx.getBean("noteService",NoteService.class);
		List<Map<String,Object>> list = service.listNotes(notebookId);
		for(Map<String,Object> n:list){
			System.out.println(n);
		}
	}
	
	
	@Test
	public void testLoadNote(){
		String id = "53d1b3ed-59a1-4715-a7b2-9027b0d551e0";
		NoteService service = ctx.getBean("noteService",NoteService.class);
		Note note = service.loadNote(id);
		System.out.println(note);
	}
	
	
	@Test
	public void testSaveNote(){
		String id = "53d1b3ed-59a1-4715-a7b2-9027b0d551e0";
		NoteService service = ctx.getBean("noteService",NoteService.class);
		boolean b = service.saveNote(id, "Java", "Java hello World!");
		System.out.println(b);
		Note n = service.loadNote(id);
		System.out.println(n);
	}
	
	
	@Test
	public void testServiceAddNote(){
		NoteService service = ctx.getBean("noteService",NoteService.class);
		String notebookId="12119052-874c-4341-b85d-6529e171ed83";
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		String title = "titletitle----";
		Note note = service.addNote(userId, notebookId, title);
		System.out.println(note);
	}
	
	
	@Test
	public void testHightSearch(){
		NoteService service = ctx.getBean("noteService",NoteService.class);
		//title  status  begin end(数据库中对应的是修改时间）
		//List<Map<String,Object>> list = service.hightSearch(null, null, null, null);
		//四个条件都是null，表示没有条件限制，有227条数据
		List<Map<String, Object>> list;
		try {
			list = service.hightSearch(null, null, "2015-12-26", null);
			for(Map<String,Object> n:list){
				System.out.println(n);
	}
	System.out.println("搜索数量："+list.size());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
