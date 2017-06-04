package cn.tedu.demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo07 {

	public static void main(String[] args) 
		throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名：");
		String className=in.nextLine();
		Class cls = Class.forName(className);
		//动态查找方法
		Method[] methods = 
			cls.getDeclaredMethods();
		Object obj = cls.newInstance();
		for(Method method: methods){
			//查找注解
			//查找 方法上是否包含@Test
			//如果包含注解就返回一个注解对象，
			//否则返回null
			Test ann= method
				.getAnnotation(Test.class);
			System.out.println(ann);
			if(ann != null){
				method.invoke(obj);
			}
		}
	}
//其中：method.getAnnotation(Test.class) 方法用于在方法上查询特定的注解。
	/*
	 * 常见面试题目:
	 * 注解是如何工作的，原理是什么
	答：在运行期间利用反射API解析并且处理注解。
	 */
}




