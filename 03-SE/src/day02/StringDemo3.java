package day02;
/**
 * String replaceAll(String regex,String str)
 * 将当前字符串中满足正则表达式的部分替换为给定
 * 的字符串内容
 * @author adminitartor
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jkl";
		/*
		 * 将当前字符串中的数字部分替换为"#NUMBER#"
		 * 将英文部分替换为#CHAR#
		 */
		str = str.replaceAll("[a-z]+", "#CHAR#");
		System.out.println(str);
	}
}







