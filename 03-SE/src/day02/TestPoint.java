package day02;
/**
 * 使用该类测试Point重写Object的相关方法
 * @author adminitartor
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point(1,2);
		
		String str = p.toString();
		System.out.println(str);
		/*
		 * System.out.println(Object obj)
		 * 该方法会将给定对象的toString返回的
		 * 字符串输出到控制台。
		 * 只有我们自己定义的类需要重写，java提供
		 * 的基本上都重写了toString方法。
		 */
		System.out.println(p);
	
		
		Point p1 = new Point(1,2);
		
		System.out.println(p==p1);//false
		
		System.out.println(p.equals(p1));//true
		
		
		String s1 = "hello";
		String s2 = new String("hello");
		
		System.out.println(s1==s2);
		//String重写了equals方法
		System.out.println(s1.equals(s2));
	}
}








