package ooday02;
//T����J�͵Ĳ�����
public class TJTest {	
	public static void main(String[] args) {
		T t = new T(2,5);
		System.out.println("ԭʼλ��:");
		t.print();
		
		System.out.println("�����:");
		t.drop();
		t.print();
		
		System.out.println("���ƺ�:");
		t.moveLeft();
		t.print();
	
		
		J j=new J(2,5);
		System.out.println("ԭʼλ��:");
		j.print();
		
		System.out.println("�����:");
		j.drop();
		j.print();
		
		System.out.println("���ƺ�:");
		j.moveLeft();
		j.print();
		
		

	}

}
