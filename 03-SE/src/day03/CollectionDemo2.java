package day03;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

/**
 * 判断集合是否包含指定元素
 * @author adminitartor
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		
		System.out.println(c);
		
		Point p = new Point(1,2);
//		c.add(p);
		/*
		 * boolean contains(E e)
		 * 判断当前集合是否包含给定的元素
		 * 是否包含给定元素是依靠该元素与集合现有
		 * 元素有没有equals比较为true的，有的话则
		 * 认为包含该元素。
		 */
		if(c.contains(p)){
			System.out.println("包含");
		}else{
			System.out.println("不包含");
		}
		System.out.println(c);
	}
}







