package day01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串是不变对象，即:对象内容不可改变。若改变
 * 字符串内容一定创建新对象。
 * 字符串推荐使用字面量形式创建(有优化效果)
 * @author adminitartor
 *
 */
public class SringDemo1 {
	public static void main(String[] args) {
		String s0 = new String("123abc");
		String s1 = "123abc";
		System.out.println(s0.equals(s1));
		String s2 = "123abc";
		String s3 = "123abc";
		//对于重复出现的字符串直接量，JVM首先会在常量池中进行查找，如果存在即返回该对象
		System.out.println(s1==s2); //true
		System.out.println(s1==s3);//true
		String s4 = new String("123abc");
		System.out.println(s1==s4);//false
		/*
		 * 编译器有一个优化措施，即:当一个计算表达式
		 * 的计算符两边都是字面量时，那么编译器会直接
		 * 将结果计算出来并编译到.class文件中。
		 * 所以，下面的代码在class文件中为:
		 * String s5 = "123abc";
		 */
		String s5 = "123"+"abc";
		System.out.println(s1==s5);//true
		
		String s6 = "123";
		String s7 = s6+"abc";
		System.out.println(s1==s7);//false
		
		String s8 = 1+"2"+"3abc";
		System.out.println(s1==s8);//true
				
		String s9 = 1+'2'+3+"abc";
		System.out.println(s1==s9);//false
		
		//考点
		char c[] = {'1','2','3','a','b','c'};
		System.out.println("============"+s8.equals(c));
		//String字符串只保存所有的单单的字符串，而char c[] 会在最后自动加上'\0'
			
		List<String> list = new ArrayList<String>();
		String[] strings = (String[]) list.toArray();
		String[] strings2 = list.toArray(new String[]{});
	}
}



