package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		//返回数据集合
		List<Map> list=
		noteDao.findByBookId(bookId);
		//构建Result
		NoteResult<List<Map>> result
		=new NoteResult<List<Map>>();
		result.setStatus(0);
		result.setMsg("加载笔记成功!");
		result.setData(list);
		
		return result;
	}
	public NoteResult<Note> loadNote(String noteId) {
		Note note=
				noteDao.findByNoteId(noteId);
		NoteResult<Note> result=
				new NoteResult<Note>();
		if(note==null){
			result.setStatus(1);
			result.setMsg("未找到数据!");
			return result;
		}else{
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(note);
			return result;
		}
	}
	@Transactional
	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		//创建note参数
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		Long time=System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		//更新数据库记录
		int rows=noteDao.updateNote(note);
		//构建result
		NoteResult<Object> result
			=new NoteResult<Object>();
		if(rows==1){
			result.setStatus(0);
			result.setMsg("保存笔记成功");
			return result;
		}else{
			result.setStatus(1);
			result.setMsg("保存笔记失败");
			return result;
		}
	}
	public NoteResult<Note> addNote(String userId, String bookId, String title) {
		Note note= new Note();
		//用户ID
		note.setCn_user_id(userId);
		//笔记本ID
		note.setCn_notebook_id(bookId);
		//笔记标题
		note.setCn_note_title(title);
		//笔记ID
		String noteId=NoteUtil.createId();
		note.setCn_note_id(noteId);
		//笔记内容
		note.setCn_note_body("");
		//创建时间
		Long time=System.currentTimeMillis();
		note.setCn_note_create_time(time);
		//最后修改时间
		note.setCn_note_last_modify_time(time);
		//状态:1-normal 2-delete
		note.setCn_note_status_id("1");
		//类型:1-normal 2-favor 3-share
		note.setCn_note_type_id("1");
		noteDao.save(note);
		//构建result
		NoteResult<Note> result=
							new NoteResult<Note>();
		result.setStatus(0);
		result.setMsg("创建笔记成功!");
		result.setData(note);
		
		return result;
	}
	
	@Transactional
	public void deleteNotes(String... ids) {
		// String... 就是 String[] 
		for (String id : ids) {
			int n = noteDao.deleteNote(id);
			if(n!=1){
				//抛出异常触发,事务的回滚!
				throw new RuntimeException("删错了!");
			}
		}
	}
}







