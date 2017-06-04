package day05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 有序的HashMap 存储顺序与迭代顺序一致
 * 
 * @author adminitartor
 *
 */
public class MapDemo4 {
	public static void main(String[] args) {
		Map<String, Integer> map 
			= new LinkedHashMap<String, Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 99);
		
//		System.out.println(map);
		
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		Set<Entry<String,Integer>> entrySet 
			= map.entrySet();
		for(Entry<String,Integer> e : entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
	}
}





