package day01;
/**
 * static String valueOf(...)
 * String提供了若干的静态重载方法valueOf,可以将
 * java中的其他类型转换为字符串类型。
 * 常用于将基本类型转换为字符串类型
 * @author adminitartor
 *
 */
public class StringDemo9 {
	public static void main(String[] args) {
		int a = 123;
		
		String astr = String.valueOf(a);
		System.out.println(astr+4); 
		
		double d = 123.123;
		String dstr = String.valueOf(d);
		System.out.println(dstr+"4");
		
		astr = a+"";
	}
}







