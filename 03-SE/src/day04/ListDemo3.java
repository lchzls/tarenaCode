package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * 对List取子集
 * @author adminitartor
 *
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Integer> list 
			= new ArrayList<Integer>();
		
		for(int i=0;i<10;i++){
			list.add(i);
		}
		//[0,1,2,3,4,5,6,7,8,9]
		System.out.println(list);
		/*
		 * List subList(int start,int end)
		 * 截取指定范围内的元素
		 */
		//取3-7
		List<Integer> subList 
			= list.subList(3, 8);
		System.out.println(subList);
		
		/*
		 * 将子集元素扩大10倍
		 */
		for(int i=0;i<subList.size();i++){
			int n = subList.get(i);
			n = n * 10;
			subList.set(i, n);
		}
		System.out.println(subList);
		/*
		 * 对子集元素的修改就是对原集合相应元素的
		 * 修改!
		 */
		System.out.println(list);
		
		/*
		 * 删除list中2-8的元素
		 */
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}





