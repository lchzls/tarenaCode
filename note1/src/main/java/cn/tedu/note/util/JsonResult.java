package cn.tedu.note.util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{


	private static final long serialVersionUID = -895513777954006421L;
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	
	
	
	private int state;
	private T data;
	private String message;
	

	public JsonResult(){
		
	}
	
	//成功
	public JsonResult(T t){
		state = SUCCESS;
		data = t;
		message="";
	}
	
	//失败(所有的失败）
	public JsonResult(Throwable e){
		state = ERROR;
		data = null;
		message=e.getMessage();
	}
	
	//记录具体情况的失败
	public JsonResult(int state,Throwable e){
		this.state = state;
		data = null;
		message = e.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
