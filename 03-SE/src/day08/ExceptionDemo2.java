package day08;
/**
 * finally块
 * finally块只能定义在异常捕获机制的最后。
 * 可以直接跟在try后面，或者最后一个catch之后。
 * finally块可以保证其中的代码无论try中的代码
 * 是否抛出异常都一定被执行。
 * finally块中通常会用来诸如做释放资源等操作。
 * @author adminitartor
 *
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "";
			System.out.println(str.length());
		} catch (Exception e) {
			System.out.println("出错了!");
		} finally{
			System.out.println("finally中的代码执行了!");
		}
		System.out.println("程序结束了");
	}
}









