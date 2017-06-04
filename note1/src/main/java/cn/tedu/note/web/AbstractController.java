package cn.tedu.note.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.util.JsonResult;

public abstract class AbstractController {

	//将鼠标放到警告上，选择添加这个注解，消除警告
		@SuppressWarnings("rawtypes")
		@ExceptionHandler(Exception.class)
		@ResponseBody
		public JsonResult exp(Exception e){
			e.printStackTrace();
			return new JsonResult(e);
		}
		
}
