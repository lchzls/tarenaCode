package day02;
/**
 * 所有的包装类都提供了一个静态方法:parseXXX()
 * 该方法可以将给定的字符串转换为对应的基本类型
 * 数字，但是前提是该字符串的内容必须能正确描述
 * 该基本类型可以保存的数据，否则会抛出异常
 * @author adminitartor
 *
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		String str = "123";
		int i = Integer.parseInt(str);
		
		double d = Double.parseDouble(str);
		System.out.println(i+1);
		System.out.println(d);
	}
}
