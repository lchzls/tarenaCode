package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * List集合是可重复集，并且有序
 * 特点是可以通过下标操作元素。
 * 常用实现类:
 * ArrayList:数组实现，查询性能更好
 * LinkedList:链表实现，增删性能更好，尤其首尾增删
 * @author adminitartor
 *
 */
public class ListDemo1 {
	public static void main(String[] args) {
		/*
		 * java.util.ArrayList
		 * java.util.LinkedList
		 */
		List<String> list
			= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		/*
		 * E get(int index)
		 * 获取指定位置的元素
		 */
		//获取第三个元素
		String str = list.get(2);
		System.out.println(str);
		
		/*
		 * E set(int index,E e)
		 * 将给定元素设置到指定位置，返回值为
		 * 原位置对应的元素
		 */
		//[one, two, three, four, five]
		System.out.println(list);
		//[one, 2, three, four, five]
		String old = list.set(1, "2");
		System.out.println(list);
		System.out.println(old);
		
		//注意，null可以作为list的一个元素
		list.add(null);
		System.out.println(list);
	}
}









