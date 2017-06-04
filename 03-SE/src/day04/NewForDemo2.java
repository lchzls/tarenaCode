package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 新循环遍历集合
 * @author adminitartor
 *
 */
public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		/*
		 * 新循环在遍历集合时，编译器在编译后会
		 * 改为使用迭代器遍历集合，所以不能在新
		 * 循环内部使用集合的方法删除元素。
		 */
	   
		for(Object o : c){
			String str = (String)o;			
			System.out.println(str);
			
		}
	}
}







