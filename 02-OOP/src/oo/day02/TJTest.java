package oo.day02;
//T型与J型的测试类
public class TJTest {
	public static void main(String[] args) {
		T t = new T(2,5);
		System.out.println("原始位置:");
		t.print();
		
		System.out.println("下落后:");
		t.drop();
		t.print();
		
		System.out.println("左移后:");
		t.moveLeft();
		t.print();
	}
}















