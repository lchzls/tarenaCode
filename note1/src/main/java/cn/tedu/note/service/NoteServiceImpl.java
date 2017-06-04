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
			throw new NotebookNotFoundException("id��");
		}
		Notebook notebook = notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("�ñʼǱ�������");
		}
		
		return noteDao.findNotesByNotebookId(notebookId);
	}


	public Note loadNote(String id) throws NoteNotFoundException {
		if(id==null||id.trim().isEmpty()){
			throw new NoteNotFoundException("id��");
		}
		Note note =  noteDao.findNoteById(id);
		if(note==null){
			throw new NoteNotFoundException("id����");
		}
		return note;
	}


	public boolean saveNote(String id, String title, String body) throws NoteNotFoundException {
		if(id==null||id.trim().isEmpty()){
			throw new NoteNotFoundException("id��");
		}
		int num = noteDao.countNotesById(id);
		if(num!=1){
			throw new NoteNotFoundException("û�бʼ�");
		}
		Map<String,Object> note =
				new HashMap<String,Object>();
		if(title!=null&&!title.trim().isEmpty()){
			//���ı�ԭ��title
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
			throw new UserNotFoundException("id��");
		}
		User user = userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("�û�������");
		}
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("�ʼǱ�idΪ��");
		}
		Notebook notebook = notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("�ʼǱ�������");
		}
		//��titleΪ�գ����һ��Ĭ�ϵ�title
		//if(title==null&&title.trim().isEmpty()){ע�⣬���ﲻ��дtitle.trim().isEmpty()��
		//��Ϊ��title��Ϊnull����title.trim().isEmpty()�ᱨ��ָ���쳣
		if(title==null){
			title = "��������";
		}
	
		String id = UUID.randomUUID().toString();
		String statusId = "0";
		String typeId="0";
		String body = "";
		long time = System.currentTimeMillis();
		Note note = new Note(id,notebookId,userId,statusId,typeId,title,body,time,time);
		int n = noteDao.addNote(note);
		if(n!=1){
			throw new NoteNotFoundException("����ʧ��");
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
		//status:2 ȫ��  1����  0ɾ��  ��Ϊ2�������ȫ������ʾû�����where��������ˣ�����Ҫ����map��
		if(status!=null&&!"2".equals(status)){
			params.put("status", status);
		}
		if(begin!=null&&!"".equals(begin)){
			//���ַ���ת�����ڣ�Long��ʾ)
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
			//���ַ���ת�����ڣ�Long��ʾ)
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
