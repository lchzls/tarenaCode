package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合元素
 * Collection提供了方法:
 * Iterator iterator()
 * 该方法会返回一个可以遍历当前集合的迭代器实例
 * 
 * java.util.Iterator
 * 是迭代器接口，规定了遍历集合的方法，不同的集合
 * 实现类都实现了可以遍历自身的迭代器实现类。我们
 * 无需记忆每一个具体实现类，只要当做是Iterator看
 * 待并可以遍历该集合即可。
 * 
 * 迭代器遍历集合遵循:
 * 问，取，删
 * 其中删除不是必须操作。
 * @author adminitartor
 *
 */
public class CollectionDemo3 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		c.add("#");
		c.add("five");
		
		Iterator it = c.iterator();
		/*
		 * boolean hasNext()
		 * 判断当前集合是否还有元素可以取出
		 */
		while(it.hasNext()){
			/*
			 * E next()
			 * 从集合中取出一个元素
			 */
			String str = (String) it.next();
			if("#".equals(str)){
				/*
				 * 在使用迭代器遍历集合的过程中
				 * 是不能通过集合的方法删除元素
				 * 的，否则会抛出异常。
				 */
//				c.remove(str);
				/*
				 * 通过迭代器的remove可以从集合
				 * 中删除通过next遍历出的元素
				 */
			//	it.remove();
			}
			System.out.println(str);
		}
		System.out.println(c);
	}
}






