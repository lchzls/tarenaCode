package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List提供了一对重载的add,remove方法
 * 
 * @author adminitartor
 *
 */
public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list 
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		
		//[one, two, three, four, five]
		System.out.println(list);
		/*
		 * void add(int index,E e)
		 * 在当前集合指定位置插入指定元素
		 */
		//[one, 2, two, three, four, five]
		list.add(1,"2");
		System.out.println(list);
		
		/*
		 * E remove(int index)
		 * 删除指定位置上的元素,返回值为被删除
		 * 的元素
		 */
		//[one, 2,two, three, four, five]
		String old = list.remove(2);
		System.out.println(list);
		System.out.println(old);
	}
}






