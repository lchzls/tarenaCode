package cn.tedu.demo;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 动态获取类中的方法信息
 */
public class Demo02 {
	public static void main(String[] args)
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名：");
		String className = in.nextLine();
		Class cls = Class.forName(className);
		//找类中全部的方法信息
		Method[] methods = 
			cls.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		//利用方法签名找到一个方法信息
		String name = "test";
		//int.class 表示int类型
		Class[] types = 
			{String.class,int.class}; 
		Method m = cls.getDeclaredMethod(
			name, types);
		System.out.println(m); 
	}
}







