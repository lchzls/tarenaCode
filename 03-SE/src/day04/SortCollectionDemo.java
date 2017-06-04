package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 对集合的排序
 * Collections是集合的工具类，提供了很多操作集合
 * 的方法。其中静态方法sort用来对List集合进行自然
 * 排序，即:从小到大
 * @author adminitartor
 *
 */
public class SortCollectionDemo {
	public static void main(String[] args) {
		List<Integer> list
			= new ArrayList<Integer>();
		
		Random random = new Random();
		for(int i=0;i<10;i++){
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
	}
}





