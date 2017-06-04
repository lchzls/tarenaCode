package oo.day06;
//匿名内部类的演示
public class NstInnerClassDemo {
	public static void main(String[] args) {
		//Inter2 o1 = new Inter2(); //编译错误，创建接口的对象，而接口不能被实例化
		
		//1)为Inter2创建一个子类，但是没有名字
		//2)为该子类创建了一个对象，名为o1
		//3)大括号中的为子类的类体
		Inter2 o1 = new Inter2(){
			
		};
		
		//1)为Inter2创建一个子类，但是没有名字
		//2)为该子类创建了一个对象，名为o2
		//3)大括号中的为子类的类体
		Inter2 o2 = new Inter2(){
			
		};
		
		final int num = 250;
		Inter3 o3 = new Inter3(){
			public void run(){
				System.out.println("runrun");
				System.out.println(num);
			}
		};
		o3.run();
		
	}
	
}

interface Inter2{
}

interface Inter3{
	void run();
}

