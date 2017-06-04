package day02;
/**
 * 字符串支持正则表达式的相关方法一:
 * boolean matches(String regex)
 * 根据给定的正则表达式验证当前字符串是否
 * 满足格式要求，满足则返回true。
 * 需要注意，该方法是全匹配验证，
 * 即:无论正则表达式是否添加边界匹配都做全匹配验证
 * @author adminitartor
 *
 */
public class StringDemo1 {
	public static void main(String[] args) {
		/*
		 * email的正则表达式:
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\.[a-zA-Z]+)+
		 * 
		 */
		String mail = "fancq@tedu.cn";
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";
		System.out.println(regex);
		boolean match = mail.matches(regex);
		if(match){
			System.out.println("是邮箱");
		}else{
			System.out.println("不是邮箱");
		}
	}
}

