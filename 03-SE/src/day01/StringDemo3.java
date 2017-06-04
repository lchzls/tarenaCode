package day01;
/**
 * int indexOf(String str)
 * 返回给定字符串在当前字符串中的位置
 * 若当前字符串不包含给定字符串则返回-1
 * @author adminitartor
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		//java编程思想
		//0123456789012345
		String str = "thinking in java";
		//查找in的位置
		int index = str.indexOf("in");
		System.out.println(index);
		//从指定位置开始查找
		index = str.indexOf("in", 3);
		System.out.println(index);
		//查找最后一次出现的位置
		index = str.lastIndexOf("in");
		System.out.println(index);
	}
}







