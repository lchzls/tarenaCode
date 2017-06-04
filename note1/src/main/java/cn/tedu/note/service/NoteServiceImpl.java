package cn.tedu.note.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.entity.User;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

	@Resource
	private NoteDao noteDao;
	
	@Resource
	private NotebookDao notebookDao;
	
	@Resource
	private UserDao userDao;
	
	public List<Map<String, Object>> listNotes(String notebookId) throws NotebookNotFoundException {
		
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("id空");
		}
		Notebook notebook = notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("该笔记本不存在");
		}
		
		return noteDao.findNotesByNotebookId(notebookId);
	}


	public Note loadNote(String id) throws NoteNotFoundException {
		if(id==null||id.trim().isEmpty()){
			throw new NoteNotFoundException("id空");
		}
		Note note =  noteDao.findNoteById(id);
		if(note==null){
			throw new NoteNotFoundException("id错误");
		}
		return note;
	}


	public boolean saveNote(String id, String title, String body) throws NoteNotFoundException {
		if(id==null||id.trim().isEmpty()){
			throw new NoteNotFoundException("id空");
		}
		int num = noteDao.countNotesById(id);
		if(num!=1){
			throw new NoteNotFoundException("没有笔记");
		}
		Map<String,Object> note =
				new HashMap<String,Object>();
		if(title!=null&&!title.trim().isEmpty()){
			//不改变原有title
			note.put("title", title);
		}
		if(body==null){
			body="";
		}
		note.put("body", body);
		note.put("id", id);
		note.put("lastModifyTime", System.currentTimeMillis());
		int n = noteDao.updateNote(note);
		return n==1;

	}


	public Note addNote(String userId, String notebookId, String title) throws UserNotFoundException, NotebookNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("id空");
		}
		User user = userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("笔记本id为空");
		}
		Notebook notebook = notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("笔记本不存在");
		}
		//若title为空，则给一个默认的title
		//if(title==null&&title.trim().isEmpty()){注意，这里不能写title.trim().isEmpty()，
		//因为若title真为null，则title.trim().isEmpty()会报空指针异常
		if(title==null){
			title = "葵花宝典";
		}
	
		String id = UUID.randomUUID().toString();
		String statusId = "0";
		String typeId="0";
		String body = "";
		long time = System.currentTimeMillis();
		Note note = new Note(id,notebookId,userId,statusId,typeId,title,body,time,time);
		int n = noteDao.addNote(note);
		if(n!=1){
			throw new NoteNotFoundException("保存失败");
		}
		return note;
	}


	public List<Map<String,Object>> hightSearch(String title, 
			String status, String begin, String end) throws ParseException{
		Map<String,Object> params = new HashMap<String,Object>();
		if(title!=null&&!"".equals(title)){
			title="%"+title+"%";
			params.put("title", title);
		}
		//status:2 全部  1正常  0删除  若为2，则代表全部，表示没有这个where条件，因此，不需要放入map中
		if(status!=null&&!"2".equals(status)){
			params.put("status", status);
		}
		if(begin!=null&&!"".equals(begin)){
			//将字符串转成日期（Long表示)
			SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd"	
			);
			
			try {
				Date begindate = sdf.parse(begin);
				params.put("beginDate", begindate.getTime());
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			
		}
		if(end!=null&&!"".equals(end)){
			//将字符串转成日期（Long表示)
			SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd"	
			);
			try {
				Date enddate = sdf.parse(end);
				params.put("endDate", enddate.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
		}
		
		return  noteDao.hightSearch(params);
		
	}


	public boolean recycleNote(String noteId) {
		int n = noteDao.updateStatus(noteId);
		return n==1;
	}

}
