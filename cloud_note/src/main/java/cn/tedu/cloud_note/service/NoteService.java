package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Map>> loadBookNotes(
			String bookId);
	public NoteResult<Note> loadNote(String noteId);
	
	public NoteResult<Object> updateNote (
			String noteId,
			String title,
			String body);
	public NoteResult<Note> addNote(
			String userId,
			String bookId,
			String title);
	
	// String... 动态参数, 就是String[] 数组
	void deleteNotes(String... ids); 
	
}









