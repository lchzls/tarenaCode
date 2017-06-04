package day01;
/**
 * String substring(int start,int end)
 * 截取字符串
 * 传入的两个参数分别为要截取边界的下标
 * 在java api中，通常使用两个数字表示范围时，都是
 * 含头不含尾的，即，包含起始下标对应内容，但不包含
 * 结束下标处对应的内容。
 * @author adminitartor
 *
 */
public class StringDemo4 {
	public static void main(String[] args) {
		//012345678901234567
		String str = "http://www.sohu.com";
		//截取域名
		String name = str.substring(11,15);
		System.out.println(name);
		
		name = str.substring(7);
		System.out.println(name);
		
		int start = str.indexOf(".")+1;
		int end = str.indexOf(".",start);
		name = str.substring(start,end);
		System.out.println(name);
	}
}






