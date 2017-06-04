package oo.day04;
//重写与重载的区别
public class OverrideOverloadDemo {
	public static void main(String[] args) {
		//重载看引用，重写看对象
		//test方法是重载，看引用，引用为Eoo，因此执行void test(Eoo o)方法
		//o.show()，show方法是重写，重写看对象，o属于Foo对象，因此，输出子类show
		Goo goo = new Goo();
		Eoo o = new Foo();
		goo.test(o);	
	}
}
class Goo{
	void test(Eoo o){
		System.out.println("父型参数");
		o.show();
	}
	void test(Foo o){
		System.out.println("子型参数");
		o.show();
	}
}
class Eoo{
	void show(){
		System.out.println("父类show");
	}
}
class Foo extends Eoo{
	void show(){
		System.out.println("子类show");
	}
}












