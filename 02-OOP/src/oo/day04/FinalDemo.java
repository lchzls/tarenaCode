package oo.day04;
//final的演示
public class FinalDemo {
	public static void main(String[] args) {
		
	}
}

final class Roo{} //演示final修饰类
//class Soo extends Roo{} //编译错误，final修饰的类不能被继承
class Too{}
final class Uoo extends Too{} //正确，final修饰的类可以继承别的类


class Poo{ //演示final修饰方法
	final void show(){}
	void say(){}
}
class Qoo extends Poo{
	//void show(){} //编译错误，final修饰的方法不能被重写
	void say(){}
}

/*
 * final修饰成员变量，只有两种初始化方式:
 *   1)声明的同时初始化
 *   2)构造方法中初始化
 * final修饰局部变量，用之前赋值即可
 */
class Ooo{ //演示final修饰变量
	final int a = 5;
	final int b;
	Ooo(){
		b = 8;
	}
	void test(){
		final int c; //用之前赋值即可
		//a = 55; //编译错误，final修饰的变量不能被改变
	}
}












