package oo.day05;
//static final常量的演示
public class StaticFinalDemo {
	public static void main(String[] args) {
		//System.out.println(Aoo.PI); //常量通过类名.来访问
		//Aoo.PI = 3.1415926; //编译错误，常量不能被改变
		
		//1)加载Boo.class到方法区中
		//2)count变量一并存在方法区中
		//3)到方法区中获取count的值并输出
		System.out.println(Boo.count);
		
		//编译器在编译时直接替换为
		//System.out.println(8);----效率高
		System.out.println(Boo.NUM);
		
	}
}

class Boo{
	public static int count = 5; //静态变量
	public static final int NUM = 8; //常量
}

class Aoo{
	public static final double PI = 3.14159;
	//public static final int NUM; //编译错误，必须声明同时初始化
}
