package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历Map 遍历Map有三种方式: 1:遍历所有的key 2:遍历所有的键值对 3:遍历所有的value(相对不常用)
 * 
 * @author adminitartor
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, Integer> map 
			= new HashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
		/*
		 * Set<K> keySet()
		 * 将当前Map中的所有key存入一个Set集合
		 * 后将其返回。那么遍历这个Set集合就等同
		 * 与遍历了所有的key
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * 遍历每一组键值对
		 * 在Map中每一组键值对是用一个Map的内部类
		 * Entry的实例保存的，Entry提供了两个方法
		 * getKey,getValue来分别获取其表示的这组
		 * 键值对中的key和value
		 * 
		 * Set<Entry> entrySet()
		 * 该方法会将当前Map中每组键值对(若干的
		 * Entry实例)存入到一个Set集合，并将其
		 * 返回。
		 */
		Set<Entry<String,Integer>> entrySet 
			= map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		
		/*
		 * Collection values()
		 * 将当前Map中所有的value存入到一个集合
		 * 中并将其返回
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
			
		}
		
	}
}














