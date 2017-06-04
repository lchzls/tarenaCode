package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections的sort方法排序List集合时
 * 要求List集合元素必须实现可比较接口。
 * @author adminitartor
 *
 */
public class SortListDemo1 {
	public static void main(String[] args) {
		List<Point> list
			= new ArrayList<Point>();
		list.add(new Point(2,3));
		list.add(new Point(1,1));
		list.add(new Point(4,3));
		list.add(new Point(5,2));
		list.add(new Point(1,6));
		System.out.println(list);
		/*
		 * sort方法要求集合元素必须实现
		 * Comparable接口
		 */
		Collections.sort(list);
		System.out.println(list);
		
	}
}






