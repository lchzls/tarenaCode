package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合操作
 * @author adminitartor
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		c1.add("java");
		c1.add(".net");
		c1.add("android");
		c1.add("c");
		System.out.println(c1);
		
		Collection c2 = new HashSet();
		c2.add("c");
		c2.add("c++");
		c2.add("oc");//objective-c
		System.out.println(c2);
		/*
		 * boolean addAll(Collection c)
		 * 将给定集合中的所有元素添加到当前集合
		 * 中，当执行完毕后，当前集合元素数量发生
		 * 了改变，则返回true
		 */
		c2.addAll(c1);
		System.out.println(c2);
		
		Collection c3 = new ArrayList();
		c3.add("java");
		c3.add("c");
		c3.add("php");
		/*
		 * boolean containsAll(Collection c)
		 * 判断当前集合是否包含给定集合中的所有
		 * 元素。
		 */
		boolean contains = c2.containsAll(c3);
		System.out.println("c2全包含c3:"+contains);
		
		/*
		 * boolean removeAll(Collection c)
		 * 删除当前集合中与给定集合共有的元素
		 */
		c2.removeAll(c3);
		System.out.println(c2);
	}
}




