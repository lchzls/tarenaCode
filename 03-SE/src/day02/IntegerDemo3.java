package day02;
/**
 * JDK在1.5时推出了一个新的特性:自动拆装箱
 * 即:基本类型和引用类型之间可以直接互相赋值，无需
 * 再关注之间的转换，而编译器在编译源程序时会自动
 * 补充代码完成它们之间的转换工作。
 * 所以自动拆装箱是编译器认可，而不是虚拟机认可的。
 * @author adminitartor
 *
 */
public class IntegerDemo3 {
	public static void main(String[] args) {
		/*
		 * 自动拆箱
		 * 编译器会补充代码为:
		 * int i = new Integer(123).intValue()
		 */
		int i = new Integer(123);
		/*
		 * 自动装箱
		 * 编译器会补充代码为:
		 * Integer ii = Integer.valueOf(123);
		 */
		Integer ii = 123;
	}
}




