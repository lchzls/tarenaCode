package cn.tedu.note.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;

public interface NoteService {
	
	public boolean recycleNote(String noteId);
	
	List<Map<String,Object>> listNotes(String notebookId)
	throws NotebookNotFoundException;
	
	Note loadNote(String id) throws NoteNotFoundException;
	
	boolean saveNote(String id,String title,String body)
	throws NoteNotFoundException;
	
	
	public Note addNote(String userId,String notebookId,String title)
	throws UserNotFoundException,NotebookNotFoundException;
	
	public List<Map<String,Object>> hightSearch(String title,String status,String begin,String end) throws ParseException;
	
	
	
}
