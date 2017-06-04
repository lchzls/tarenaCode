package cn.tedu.demo;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 动态找到一个类的方法，并且执行它
 * 测试执行无参数方法 
 */
public class Demo03 {
	public static void main(String[] args) 
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名：");
		String className = in.nextLine();
		//加载类
		Class cls = Class.forName(className);
		//输入方法名
		System.out.print("输入方法名：");
		String name = in.nextLine();
		//查找方法
		Class[] types = {};
		Method method = 
			cls.getDeclaredMethod(name,types);
		//执行方法
		//String obj = "ABC";
		Object obj = cls.newInstance();
		Object val = method.invoke(obj);
		System.out.println(val);
	}
}







