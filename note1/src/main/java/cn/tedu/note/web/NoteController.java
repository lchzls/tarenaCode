package cn.tedu.note.web;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.util.JsonResult;

@Controller
@RequestMapping("/note")
public class NoteController extends AbstractController {

	@Resource
	private NoteService noteService;
	
	//为什么会删除失败呢？没有写错啊，而且删除后设置标题为""也不行？
	@RequestMapping("/recycle.do")
	@ResponseBody
	public JsonResult<Boolean> recycleNote(String noteId){
		boolean n = noteService.recycleNote(noteId);
		return new JsonResult<Boolean>(n);
	}
	
	@RequestMapping("/hightSearch.do")
	@ResponseBody
	public JsonResult<List<Map<String,Object>>> hightSearch(String title, 
			String status, String begin, String end) throws ParseException  {
		
		List<Map<String,Object>> notes = noteService.hightSearch(title, status, begin, end);
		return  new JsonResult<List<Map<String,Object>>>(notes);
	}
	
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String,Object>>> list(String notebookId){
		List<Map<String,Object>> list = noteService.listNotes(notebookId);
		return new JsonResult<List<Map<String,Object>>>(list);
	}
	

	@RequestMapping("/load.do")
	@ResponseBody
	public JsonResult<Note> load(String id){
		Note note = noteService.loadNote(id);
		return new JsonResult<Note>(note);
	}
	
	
	//save这里多次测试，从数据库后台看是否修改了数据！
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult<Boolean> save(String id,String title,String body){
		boolean b = noteService.saveNote(id, title, body);
		return new JsonResult<Boolean>(b);
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult<Note> add(String userId,String notebookId,String title){
		Note note = noteService.addNote(userId, notebookId, title);
		return new JsonResult<Note>(note);
	}
	
	
	
	
}
