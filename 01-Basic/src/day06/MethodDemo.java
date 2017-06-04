package day06;
//方法的演示
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		//say();
		
		//sayHi(); //编译错误，有参则必须传参
		//sayHi(25); //编译错误，参数类型不匹配
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi"
		//sayHi("wangwu"); //String name="wangwu"
		
		//int a = getNum(); //getNum()的值就是return后的值
		//System.out.println(a);
		
		//double m = plus(5.5,6.6); //double a=5.5,double b=6.6
		//System.out.println(m);
		
		//double n1=5.5;
		//double n2=6.6;
		//double n = plus(n1,n2); //double a=n1的5.5,double b=n2的6.6
		//System.out.println(n);
		
		a(); //方法的嵌套调用
		
		System.out.println("over");
	}
	
	//方法的嵌套调用
	public static void a(){
		System.out.println(111);
		b();
		System.out.println(222);
	}
	public static void b(){
		System.out.println(333);
		c();
	}
	public static void c(){
		System.out.println(444);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//有参有返回值
	public static double plus(double a,double b){
		//double c = a+b;
		//return c; //返回的是c里面那个数
		return a+b;
	}
	
	
	//无参有返回值
	public static int getNum(){
		//return; //编译错误，必须返回一个值
		//return 8.88; //编译错误，返回值类型不匹配
		return 66; //1.结束方法的执行  2.返回结果给调用方
	}
	
	//有参无返回值
	public static void sayHi(String name){
		System.out.println("大家好，我叫"+name);
		return; //结束方法的执行
	}
	
	//无参无返回值
	public static void say(){
		System.out.println("大家好，我叫WKJ");
	}
	
}















