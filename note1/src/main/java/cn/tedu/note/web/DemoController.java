package cn.tedu.note.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.Person;

@Controller
@RequestMapping("/demo")
public class DemoController {

	//http://localhost:8088/note1/demo/test?name=jurry
	@ResponseBody
	@RequestMapping("/test")
	public Object execute(String name){
		String[] arg = {"Tom","Jerry","Nemo",name};
		return arg;
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public Object list(){
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("sunny");
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping("/map")
	public Object map(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 100);
		map.put("name", "Tom");
		map.put("friends", new String[]{"Tom","Jerry","Nemo"});
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/person")
	public Object person(){
		Person p = new Person(5,"Tom",new String[]{"Jerry","Nemo"});
		return p;
	}
}
