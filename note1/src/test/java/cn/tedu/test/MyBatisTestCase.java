package cn.tedu.test;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.entity.User;

public class MyBatisTestCase {
	
	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		
		ctx = new ClassPathXmlApplicationContext(
				"spring-web.xml","spring-mybatis.xml","spring-service.xml");
		
	}
	
	@Test
	public void testDataSource(){
		DataSource ds = ctx.getBean("dataSource",DataSource.class);
	    System.out.println("ds:-------"+ds);
	}
	
	@Test
	public void testSqlSessionFactory(){
		SqlSessionFactory factory = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		System.out.println(factory);
	}
	
	@Test
	public void testMapperScanner(){
		MapperScannerConfigurer scanner  = ctx.getBean("mapperScanner",MapperScannerConfigurer.class);
	    System.out.println("scanner:"+scanner);
	}
	
	
	@Test
	public void testSaveUser(){
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		System.out.println(dao);
//		User user = new User("124","zls","234","","Cat");
//		dao.saveUser(user);
		
	}
	
	
	@Test
	public void testFindUserById(){
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = dao.findUserById("123");
		System.out.println(user);
	}
	
	
	@Test
	public void testFindUserByName(){
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		System.out.println(dao);
		//User user = dao.findUserByName("zls");
	//	System.out.println(user);
	}
	
	@Test
	public void testFindNotebooksByUserId(){
		String userId="ea09d9b1-ede7-4bd8-b43d-a546680df00b";
		NotebookDao dao = ctx.getBean("notebookDao",NotebookDao.class);
		System.out.println(dao);
		List<Map<String,Object>> list = dao.findNotebooksByUserId(userId);
		for(Map<String,Object> n:list){
			System.out.println(n);
		}
	}
	
	
	@Test
	public void testFindNotesByNotebookId(){
		
		String notebookId = "d0b0727f-a233-4a1f-8600-f49fc1f25bc9";
		NoteDao dao = ctx.getBean("noteDao",NoteDao.class);
		List<Map<String,Object>> list =
				dao.findNotesByNotebookId(notebookId);
		for(Map<String,Object> n:list){
			System.out.println(n);
		}
	}
	
	@Test
	public void testFindNotebookById(){
		
		String notebookId = "d0b0727f-a233-4a1f-8600-f49fc1f25bc9";
		NotebookDao dao = ctx.getBean("notebookDao",NotebookDao.class);
		Notebook notebook  =
				dao.findNotebookById(notebookId);
		System.out.println(notebook);
	}
	
	@Test
	public void testFindNoteById(){
		
		String id = "53d1b3ed-59a1-4715-a7b2-9027b0d551e0";
		NoteDao dao = ctx.getBean("noteDao",NoteDao.class);
		Note note = dao.findNoteById(id);
		System.out.println(note);
	}
	
	@Test
	public void testUpdateNote(){
		NoteDao dao = ctx.getBean("noteDao",NoteDao.class);
		String id = "53d1b3ed-59a1-4715-a7b2-9027b0d551e0";
		Map<String,Object> note = new HashMap<String,Object>();
		//加入必选参数
		note.put("id", id);
		note.put("lastModifyTime", System.currentTimeMillis());
		//加入可选参数
		note.put("title", "笨蛋");
		note.put("body", "你一定要好好加油啊");
		dao.updateNote(note);
		
	}
	
	
	@Test
	public void testCountNotesById(){
		String id = "53d1b3ed-59a1-4715-a7b2-9027b0d551e0";
		NoteDao dao = ctx.getBean("noteDao",NoteDao.class);
		int n = dao.countNotesById(id);
		System.out.println(n);
	}
	
	
	@Test
	public void testAddNote(){
		NoteDao dao = ctx.getBean("noteDao",NoteDao.class);
		String id = "111111";
		String notebookId="12119052-874c-4341-b85d-6529e171ed83";
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		String statusId="0";
		String typeId = "0";
		String title="哈哈哈哈哈哈哈哈哈哈";
		String body = "Hello";
		long now = System.currentTimeMillis();
		Note note = new Note(id,notebookId,userId,statusId,typeId,title,body,now,now);
		int n = dao.addNote(note);
		System.out.println(n);
	}
	
	@Test
	public void testUpdateUser(){
		UserDao dao = ctx.getBean("userDao",UserDao.class);
	//	System.out.println(dao);
		Map<String,Object> user = new HashMap<String,Object>();
		user.put("token", "1");
		user.put("password", "123");
		user.put("nick", "nicknick");
		user.put("id", "1234");
		int i = dao.updateUser(user);
		User u = dao.findUserById(user.get("id").toString());
		System.out.println(u);
	}
}
