package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Collections是集合的工具类
 * 提供了一组方法，可以将现有的集合或Map转换为
 * 线程安全的。
 * ArrayList,LinkedList,HashSet,HashMap都不是
 * 线程安全的。
 * @author adminitartor
 *
 */
public class SyncAPIDemo {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		/*
		 * 将给定的集合转换为一个线程安全的集合
		 */
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		//转换为线程安全的Set集合
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		System.out.println(map);
		//将给定的Map转换为线程安全的
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
		
		/*
		 * 遍历集合通常会使用迭代器，但是要注意:
		 * API文档中也描述了这一点。
		 * 迭代器遍历集合时，不与线程安全的集合
		 * 方法互斥。所以需要执行维护。
		 * 迭代器有一个特点，就是在遍历的过程中
		 * 不能通过集合的方法修改元素数量，哪怕
		 * 该集合是一个线程安全的集合，在多线程
		 * 情况下，迭代器遍历与集合元素的增删之
		 * 间也不存在互斥性，若不维护，会导致遍历
		 * 出现异常。
		 * 
		 */
	}
}








