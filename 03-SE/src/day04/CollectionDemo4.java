package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型在集合中的应用
 * 泛型在集合中被用来规定集合元素类型
 * @author adminitartor
 *
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection<String> c 
			= new ArrayList<String>();
		//泛型要求只能存入字符串元素
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		/*
		 * 迭代器的泛型与其遍历的集合泛型一致即可
		 */
		Iterator<String> it = c.iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		
		for(String str:c){
			System.out.println(str);
		}
		
	}
}





