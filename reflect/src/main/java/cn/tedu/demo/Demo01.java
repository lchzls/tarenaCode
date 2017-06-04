package cn.tedu.demo;

import java.util.Scanner;

/*
 * 动态加载类
 */
public class Demo01 {
	public static void main(String[] args)
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名:");
		String className=in.nextLine();
		//动态加载类：
		//在类名错误时候出现：Class没有找到
		Class cls = Class.forName(className);
		//如果没有无参数构造器，将抛出异常
		Object obj = cls.newInstance();
		System.out.println(cls);
		System.out.println(obj); 
	}
}





