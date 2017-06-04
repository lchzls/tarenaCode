package day04;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

/**
 * 从集合中删除元素
 * @author adminitartor
 *
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		c.add(new Point(7,8));
		c.add(new Point(1,2));
		System.out.println(c);
		/*
		 * boolean remove(E e)
		 * 将给定对象从集合中删除
		 * 只会删除集合中的一个元素，删除的是与
		 * 给定元素第一个equals比较为true的元素
		 */
		Point p = new Point(1,2);
		c.remove(p);
		System.out.println(c);
		
	}
}







