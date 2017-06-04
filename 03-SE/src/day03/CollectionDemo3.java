package day03;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

/**
 * 集合只能保存引用类型元素并且保存的是元素的引用
 * @author adminitartor
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Point p = new Point(1,2);
		//存入集合
		c.add(p);
		System.out.println(p);//(1,2)
		System.out.println(c);//[(1,2)]
		
		p.setX(2);
		System.out.println(p);//(2,2)
		System.out.println(c);//[(2,2)]
	}
}



