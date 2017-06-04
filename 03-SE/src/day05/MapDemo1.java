package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * 查找表，以key-value对的形式存储数据
 * 在Map中key是不允许重复的(equals比较)
 * 一个key对应一个value
 * 常用的Map实现类:HashMap，使用散列算法实现
 * @author adminitartor
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		/*
		 * V put(K k,V v)
		 * 将给定的key-value存入到Map中。
		 * 因为Map不允许有重复的key，所以若给定的
		 * key已经存在，这是替换value操作，返回值
		 * 为被替换的value,若不是重复的key，返回值
		 * 为null。
		 */
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		Integer num = map.put("化学", 99);
		System.out.println(num);
		System.out.println(map);
		
		num = map.put("语文", 80);
		System.out.println("old:"+num);
		
		System.out.println(map);
		
		
		/*
		 * V get(K k)
		 * 根据给定的key获取对应的value,若给定
		 * 的key在Map中不存在，这返回值为null
		 */
		num = map.get("物理");
		System.out.println("物理:"+num);
		num = map.get("体育");
		System.out.println("体育:"+num);
		
	}
}






