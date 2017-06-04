package oo.day06;

import oo.day06.Mama.Baby;

//成员内部类的演示
public class InnerClassDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		m.createBaby().showMamaName();;
		//Baby b = new Baby(); //编译错误，内部类对外不具备可见性
	}
}

class Mama{
	private String name="zhagn";
	Baby createBaby(){
		return new Baby(); //内部类通常在外部类中创建
	}
	class Baby{
		void showMamaName(){
			System.out.println(name);
			System.out.println(Mama.this.name);
			//System.out.println(this.name); //编译错误，this代表Baby类，而Baby类中没有name属性
		}
	}
}





