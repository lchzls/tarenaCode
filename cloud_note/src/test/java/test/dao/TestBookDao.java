package test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;

public class TestBookDao {
	String[] conf={"conf/spring-mvc.xml",
			"conf/spring-mybatis.xml"};
	ApplicationContext ctx
	= new ClassPathXmlApplicationContext(conf);
	@Test
	public void testDao(){
		BookDao dao
		=ctx.getBean("bookDao",BookDao.class);
		List<Book> list=
			dao.findByUserId(
				"48595f52-b22c-4485-9244-f4004255b972");
		for(Book book:list){
			System.out.println(book.getCn_notebook_id()+","+
					book.getCn_notebook_name());
		}
	}
}
