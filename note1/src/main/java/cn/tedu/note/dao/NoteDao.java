package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;

public interface NoteDao {

	public int updateStatus(String noteId);
	List<Map<String,Object>> findNotesByNotebookId(String notebookId);
	Note findNoteById(String id);
	int updateNote(Map<String,Object> note);
	int countNotesById(String id);
	int addNote(Note note);
	List<Map<String,Object>>  hightSearch(Map params);
}
