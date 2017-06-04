package cn.tedu.demo;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 执行某个类中全部以test为开头的方法
 * 	都是非静态方法
 *  方法都是无参数无返回值的方法
 *  类有无参数构造器
 */
public class Demo04 {
	public static void main(String[] args)
		throws Exception {
		Scanner in=new Scanner(System.in);
		System.out.print("输入类名：");
		String className = in.nextLine();
		//动态加载类
		Class cls=Class.forName(className);
		//动态查找方法
		Method[] methods = 
			cls.getDeclaredMethods();
		//遍历每个方法，查找方法名是以test为开头
		Object obj = cls.newInstance();
		for (Method method : methods) {
			String name=method.getName();
			//获取方法的参数类型列表
			Class[] types=
				method.getParameterTypes();
			System.out.println(
				name+":"+Arrays.toString(types));
			//检查参数类型列表长度
			if(types.length!=0){
				continue;
			}
			if(name.startsWith("test")){
				System.out.print(name+":");
				//找到了test开头方法
				//执行找到的方法
				method.invoke(obj);
			}
		}
	}
}







