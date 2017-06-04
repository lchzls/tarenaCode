package oo.day04;
//重写的演示
public class OverrideDemo {
	public static void main(String[] args) {
		/*
		Boo o1 = new Boo();
		o1.show(); //子类show
		
		Aoo o2 = new Boo(); //向上造型
		o2.show(); //子类show
		
		Aoo o3 = new Aoo();
		o3.show(); //父类show
		
		Boo o4 = new Boo();
		o4.show();
		*/
		
		
	}
}

/*
 * 重写需遵循"两同两小一大"原则:
 * 1.两同:
 *   1)方法名相同
 *   2)参数列表相同
 * 2.两小:
 *   1)子类方法的返回值类型小于或等于父类的
 *     1.1)返回值类型为void时，必须相等
 *     1.2)返回值类型为基本类型时，必须相等
 *     1.3)返回值类型为引用类型时，小于或等于
 *   2)子类方法所抛出的异常小于或等于父类的----异常之后
 * 3.一大:
 *   1)子类方法的访问权限大于或等于父类的----访问修饰符之后
 */

//父类大，子类小
class Coo{
	void show(){}
	double say(){return 0.0;}
	Coo test(){return null;}
	Doo showShow(){return null;}
	
}
class Doo extends Coo{
	//int show(){return 1;} //编译错误，void时必须相等
	//int say(){return 1;} //编译错误，基本类型时必须相等
	Doo test(){return null;} //正确的，小于
	//Coo showShow(){return null;} //编译错误，只能小于或等于，不能大于
	
}












class Aoo{
	void show(){
		System.out.println("父类show");
	}
}
class Boo extends Aoo{
	void show(){
		//super.show(); //调用父类的show方法
		System.out.println("子类show");
	}
}














