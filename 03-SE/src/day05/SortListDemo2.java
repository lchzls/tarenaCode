package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 将来有排序集合元素需求是，建议使用重载的带有
 * 比较器的比较方法。
 * 因为不带比较器的比较方法要求集合元素必须实现
 * Comparable接口，这种在使用某个功能，而该功能
 * 要求你为其修改代码的现象称为侵入性，修改的代码
 * 越多，侵入性越强，耦合度越高，不利于程序扩展。
 * 
 * 比较器解决两个问题，第一是解决了侵入性，不要求
 * 集合元素实现接口，还解决了另一种情况，即:
 * 当元素已经实现Comparable接口并定义了比较规则，
 * 但该规则不满足我们的排序需求，这时可以额外使用
 * 比较器提供比较规则。
 * 
 * @author adminitartor
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<String> list 
			= new ArrayList<String>();
		list.add("范老师");
		list.add("苍老师");
		list.add("小泽老师");
		System.out.println(list);
		//Collections.sort(list);
		
		MyComparator com = new MyComparator();
		/*
		 * 重载的sort方法要求传入一个额外的比较器
		 * 然后按照比较器的比较规则对集合元素进行
		 * 比较，再按照从小到大的顺序排序集合。
		 * 该方法不再要求元素必须实现Comparable接口
		 * 因为不使用元素自身的比较规则进行比较。
		 */
		Collections.sort(list, com);
		
		System.out.println(list);
	}
}

class MyComparator implements Comparator<String>{
	/**
	 * 比较规则:字符多的大
	 */
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
}








