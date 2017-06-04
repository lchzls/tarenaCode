package oo.day04;
//static的演示
public class StaticDemo {
	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b); //建议
		System.out.println(o1.b);  //不建议
		
		Moo.test();
		
		Noo o3 = new Noo();
		Noo o4 = new Noo();
		Noo o5 = new Noo();
		/*
		 * 静态块
		构造方法
		构造方法
		构造方法
		 */
	}
}


class Noo{
	Noo(){
		System.out.println("构造方法");
	}
	static{
		System.out.println("静态块");
	}
}






class Moo extends Loo{ //演示静态方法
    int a;
	static int b;
	void show(){
		this.a = 1;
		Moo.b = 2;
	}
	static void test(){ //没有隐式的this传递
		//a = 1; //没有this就意味着没有对象，而实例变量a必须通过对象点来访问，所以此处编译错误
		Moo.b = 2;
	}
}



class Loo{ //演示静态变量
	int a;
	static int b;
	Loo(){
		a++;
		b++;
	}
	void show(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}





