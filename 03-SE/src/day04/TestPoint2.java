package day04;

public class TestPoint2 {
	public static void main(String[] args) {
		Point<Integer> p1 
			= new Point<Integer>(1,2);
		p1.setX(2);
		int x1 = p1.getX();
		System.out.println(x1);
		/*
		 * 泛型不指定，则使用原型Object
		 */
		Point p2 = p1;
		p2.setX("二");
		System.out.println(p2.getX());//二
		System.out.println(p2);//(二,2)
		
		System.out.println(p1);//(二,2)
		x1 = (Integer)p1.getX();//ClassCastException
		System.out.println(x1);//二
	}
}




