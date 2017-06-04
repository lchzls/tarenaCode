package cn.tedu.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.util.NoteResult;
@Service("bookService")
public class BookServiceImpl implements BookService{
	@Resource
	BookDao bookDao;
	public NoteResult<List<Book>> loadUserBooks(String userId) {
		List<Book> list=
			bookDao.findByUserId(userId);
		//构建返回结果result
		NoteResult<List<Book>> result
		= new NoteResult<List<Book>>();
		
		result.setStatus(0);
		result.setMsg("查询笔记本成功");
		result.setData(list);
		
		return result;
	}

}




