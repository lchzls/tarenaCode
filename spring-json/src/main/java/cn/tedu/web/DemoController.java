package cn.tedu.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
//@ResponseBody 自动处理控制器方法 的返回值，如果是对象，则将对象转换为JSON，返回到客户端，必须依赖于jackson API

	@RequestMapping("/test")
	@ResponseBody 
	public Object execute(String name){
		String[] ary = {"Tom","Jerry","Namo",name};
		return ary;
	}
	
	@RequestMapping("/list")
	@ResponseBody 
	public Object list(){
		List<String> list = new ArrayList<String>();
		list.add("tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Mac");
		return list;
	}
	
	@RequestMapping("/map")
	@ResponseBody
	public Object map(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 100);
		map.put("name", "Tom");
		map.put("friends", new String[]{"Jerry","Mac"});
		return map;
		
	}
	
	@RequestMapping("/person")
	@ResponseBody
	public Object person(){
		Person p = new Person(5,"Jerry",new String[]{"Tom","Andy"});
		return p;
	}
	
}
