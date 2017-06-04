package cn.tedu.demo;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * 动态读写属性 
 */
public class Demo06 {
	public static void main(String[] args)
		throws Exception {
		Scanner in=new Scanner(System.in);
		System.out.print("输入类名：");
		String className = in.nextLine();
		//动态加载类
		Class cls = Class.forName(className);
		//动态获取属性信息
		System.out.print("属性名称：");
		String name = in.nextLine();
		//查找属性: 在方法区中的类信息里查找属性信息
		Field field=cls.getDeclaredField(name);
		//读取属性
		// obj 参数是包含属性值的对象
		Object obj = cls.newInstance();
		field.setAccessible(true);
		field.set(obj, 100);
		Object val = field.get(obj);
		System.out.println(val); 
	}
}



