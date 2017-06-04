package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 需要注意，转换是依靠数组的工具类Arrays的方法，
 * 该方法仅能将数组转换为List集合
 * @author adminitartor
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] array = {"one","two","three","four","five"};
		
		List<String> list = Arrays.asList(array);
		System.out.println(list);
		/*
		 * 对转换后的集合元素修改，就是对原数组
		 * 相应元素的修改!
		 */
		list.set(1, "2");
		System.out.println(list);
		
		for(String str : array){
			System.out.println(str);
		}
		/*
		 * 从数组转换过来的集合，是不能添加元素的
		 * 也不能删除元素，因为这会导致数组扩容
		 * 或缩容，这就无法表示原来的数组。
		 */
//		list.remove(1);
//		list.add("six");
		System.out.println(list);
		
		/*
		 * 若想添加新元素，需要额外创建一个集合
		 */
		List<String> list1
			= new ArrayList<String>(list);
		list1.add("six");
		System.out.println(list1);
	}
}








