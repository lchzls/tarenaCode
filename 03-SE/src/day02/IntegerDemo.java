package day02;
/**
 * 包装类
 * 由于基本类型没有面向对象特性，所以不能直接参与
 * 面向对象开发，为了解决这个问题，java为8个基本
 * 类型提供了包装类，包装类可以以对象的形式表示一个
 * 基本类型的值。
 * 其中六个数字类型的包装类继承自Number
 * Number定义了数字类型包装类应具有的共同行为:
 * 允许将其表示的基本类型数据在不同的数字类型之间
 * 互相转换。
 * @author adminitartor
 *
 */
public class IntegerDemo {
	public static void main(String[] args) {
		String string = "123";
		Integer integer = Integer.valueOf(string);
		//int -->  Integer   基本类型->引用类型
		/*
		 * 所有包装类支持静态方法valueOf，可以将
		 * 对应的基本类型转换为包装类。推荐使用
		 * 这种方式，而不是直接new。
		 */
		Integer in1 = Integer.valueOf(128);
		Integer in2 = Integer.valueOf(128);
		
	
		System.out.println(in1==in2);
		System.out.println(in1.equals(in2));
		//引用类型转换为基本类型
		int i = in1.intValue();
		double d = in1.doubleValue();
		System.out.println(d);
		byte b = in1.byteValue();
		System.out.println(b);
		
		/*
		 * 数字类型包装类提供了两个常量，可以查看
		 * 其表示的基本类型的取值
		 */
		int imax = Integer.MAX_VALUE;
		System.out.println("imax:"+imax);
		int imin = Integer.MIN_VALUE;
		System.out.println("imin:"+imin);
		
		long lmax = Long.MAX_VALUE;
		System.out.println("lmax:"+lmax);
	}
	
}










