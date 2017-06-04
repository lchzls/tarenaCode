package cn.tedu.demo;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * 动态获取一个类全部属性信息 
 */
public class Demo05 {
	public static void main(String[] args)
		throws Exception{
		Scanner	in = new Scanner(System.in);
		System.out.print("输入类：");
		String className = in.nextLine();
		Class cls = Class.forName(className);
		//动态获取一个类中定义的属性信息
		Field[] fields = 
				cls.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field); 
		}
	}

}





