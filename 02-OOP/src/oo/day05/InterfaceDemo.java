package oo.day05;
//接口的演示
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter5 o1 = new Inter5(); //编译错误，接口不能被实例化
		Foo o2 = new Foo();
		Inter6 o3 = new Foo(); //向上造型
		Inter5 o4 = new Foo(); //向上造型
		/*
		 * 接口的练习:
		 * 1.声明接口Inter1，包含常量PI和抽象方法show()
		 * 2.声明接口Inter2，包含a()和b()
		 *   声明类Aoo，实现Inter2
		 * 3.声明接口Inter3，包含c()
		 *   声明类Boo，实现Inter2和Inter3
		 * 4.声明抽象类Coo，包含抽象方法d()
		 *   声明类Doo，继承Coo，实现Inter2和Inter3
		 * 5.声明接口Inter4，继承Inter3，包含e()
		 *   声明类Eoo，实现Inter4
		 * 6.main()方法中:
		 *     Inter4 o1 = new Inter4();--------???
		 *     Inter4 o2 = new Eoo();-----------???
		 *     Inter3 o3 = new Eoo();-----------???
		 *   
		 * 
		 */
		Inter1 o1 = new Coo();
	
	}
}

//接口继承接口
interface Inter5{
	void show();
}
interface Inter6 extends Inter5{
	void say();
}
class Foo implements Inter6{
	public void say(){}
	public void show(){}
}


//一个类可以实现多个接口
//又继承又实现时，应先继承后实现
interface Inter3{
	void show();
}
interface Inter4{
	void say();
	void sayHi();
}
abstract class Doo{
	abstract void test();
}
class Eoo extends Doo implements Inter3,Inter4{
	public void show(){}
	public void say(){}
	public void sayHi(){}
	void test(){}
}




//接口的实现
interface Inter2{
	void show();
	void say();
}
class Coo implements Inter2,Inter1{
	public void show(){}
	public void say(){}
}



//接口的语法
interface Inter1{
	public static final int NUM = 250;
	public abstract void show();
	double PI = 3.14159; //默认public static final
	void say(); //默认public abstract
	
//	int   count = 78; //编译错误，接口中的数据默认为常量，常量必须声明同时初始化
	//void sayHi(){} //编译错误，接口中的方法默认为抽象的，抽象方法不能有方法体
}
















