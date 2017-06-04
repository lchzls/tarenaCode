package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了将集合转换为数组的方法:toArray
 * @author adminitartor
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c 
			= new ArrayList<String>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		System.out.println(c);
		
		//Object[] array = c.toArray();
		String[] array
			= c.toArray(new String[c.size()]);  //= c.toArray(new String[]{});  
		System.out.println("len:"+array.length);
		for(String str : array){
			System.out.println(str);
		}
		System.out.println(Arrays.toString(array));
	}
}





