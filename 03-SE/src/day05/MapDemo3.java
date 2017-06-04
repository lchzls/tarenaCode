package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * 查看Map是否包含给定内容
 * @author adminitartor
 */
public class MapDemo3 {
	public static void main(String[] args) {
		Map<String, Integer> map 
			= new HashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		/*
		 * 是否包含指定的key
		 * boolean containsKey(Object k)
		 * 判断当前Map是否包含给定的key
		 */
		boolean contains = map.containsKey("化学");
		System.out.println("是否包含该key:"+contains);
		
		/*
		 * boolean containsValue(Object v)
		 * 判断是否包含给定的value
		 */
		 contains = map.containsValue(70);
		 System.out.println("是否包含该value:"+contains);
		
	}
}





