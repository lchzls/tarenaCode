package day01;
/**
 * 文档注释，只修饰三个地方，分别是类，常量，方法
 * 文档注释会被javadoc命令生成为一个文档手册。
 * 
 * 在类上使用文档注释用来说明当前类的设计目的。
 * 
 * 当前类是用来测试文档注释的使用。
 * @author adminitartor
 * @version 1.0 2016-08-22
 * @see java.lang.String
 * @since JDK1.0
 *
 */
public class APIDocDemo {
	/**
	 * sayHello方法需要的问候短语
	 */
	public static final String INFO = "你好!";
	/**
	 * 该方法用于为指定用户生成一个问候语
	 * @param name 给定的用户的名字
	 * @return 问候语
	 */
	public static String sayHello(String name){
		return INFO + name;
	}
}





