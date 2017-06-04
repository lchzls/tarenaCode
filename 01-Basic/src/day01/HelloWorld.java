package day01; //声明包day01

public class HelloWorld { //声明类HelloWorld
/*
 * 1.输出HelloWorld
 * 2.byte、char、short三种类型参与运算时，先一律转换成int类型再进行运算
 */
	
	//主方法，为程序的入口
	//程序的执行从main开始，main结束则程序结束
	public static void main(String[] args) {
		//输出HelloWorld
		//1.java严格区分大小写
		//2.所有符号必须英文模式的
		//3.每句话必须与分号;结尾
		//4.println()输出并换行
		//  print()输出不换行
		System.out.print("HelloWorld");
		System.out.println("欢迎大家来到达内");
		System.out.println("今天天气不错，心情也不错");
		Integer a  = 1;
		int b = 1;
		System.out.println(a==b);
		
		
//byte、char、short三种类型参与运算时，先一律转换成int类型再进行运算。示例如下：
//		
//		byte a = 1;
//		byte b = 1;
//		byte c = (byte)(a+b);
		
	}
	
}






