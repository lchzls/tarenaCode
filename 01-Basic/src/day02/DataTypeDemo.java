package day02;

//数据类型的演示
public class DataTypeDemo {
	public static void main(String[] args) {
		
		/*
		 * 基本类型的转换:
		 * 1.声明整型变量a并赋值为5
		 *   声明长整型变量b并赋值为a
		 *   声明整型变量c并赋值为b
		 *   声明长整型变量d并赋值为6
		 *   声明浮点型变量e并赋值为6，输出e的值
		 * 2.声明长整型变量f并赋值为100亿L
		 *     声明整型变量g并赋值为f，输出g的值
		 *   声明浮点型变量h并赋值为65.985
		 *     声明整型变量i并赋值为h，输出i的值
		 * 3.声明byte型变量b1和b2，并分别赋值为5和6
		 *     声明byte型变量b3并赋值为b1+b2，输出b3的值   
		 *   
		 */
		
		
		
		
		
		
		/*
		//基本类型的转换:
		int a=5;
		long b=a; //自动类型转换
		int c=(int)b; //强制类型转换
		
		long d=5; //自动类型转换
		double e=5; //自动类型转换
		
		long f=10000000000L;
		int g=(int)f;
		System.out.println(g); //强转有可能会溢出
		
		double h=365.98745;
		int i=(int)h;
		System.out.println(i); //强转有可能会精度丢失
		
		byte b1=5;
		byte b2=6;
		byte b3=(byte)(b1+b2);
		System.out.println(b3); //11
		*/
		
		
		
		
		/*
		 * boolean、 char的练习:
		 * 1.声明布尔型变量b1并赋值为true
		 *   声明布尔型变量b2并赋值为false
		 *   声明布尔型变量b3并赋值为250--------???
		 * 2.声明字符型变量c1并赋值为字符男
		 *   声明字符型变量c2并赋值为字符m
		 *   声明字符型变量c3并赋值为字符5
		 *   声明字符型变量c4并赋值为空格符
		 *   声明字符型变量c5并赋值为空字符------???
		 *   声明字符型变量c6并赋值为字符中国----???
		 *   声明字符型变量c7并赋值为65，
		 *      输出c7的值
		 *   输出2+2的值，输出2+'2'的值，输出'2'+'2'的值
		 *   声明字符型变量c8并赋值为'，
		 *      输出c8的值
		 */
		
		
		
		
		
		
		
		
		/*
		//5.char:字符型，2个字节
		//       必须放在单引号中，有且仅有一个
		char c1='女';
		char c2='f';
		char c3='8';
		char c4=' ';
		//char c5=你; //编译错误，必须放在单引号中
		//char c6='你好'; //编译错误，只能有一个
		//char c7=''; //编译错误，必须有一个字符
		
		char c8=97; //数字必须在0到65535之间
		System.out.println(c8); //a
		
		System.out.println(2+2); //4
		System.out.println('2'+'2'); //100，'2'的码50，加上，'2'的码50
		
		char c9='\'';
		System.out.println(c9); //'
		*/
		
		/*
		//4.boolean:布尔型，1个字节，只能取值为true和false
		boolean b1=true;  //true为布尔型直接量
		boolean b2=false; //false为布尔型直接量
		//boolean b3=250; //编译错误，数据类型不匹配
		*/
		
		
		
		
		
		/*
		 * int、long、double的练习:
		 * 1.声明整型变量a并赋值为250
		 *   声明整型变量b并赋值为100亿------???
		 *   声明整型变量c并赋值为3.14-------???
		 *   输出5/2的值，输出2/5的值，输出5/2.0的值
		 *   声明整型变量d并赋值为2147483647
		 *     在d本身基础之上增1，输出d的值
		 * 2.声明长整型变量e并赋值为100亿-----???
		 *   声明长整型变量f并赋值为100亿L
		 *   声明长整型变量g并赋值为10亿*2*10L，输出g
		 *   声明长整型变量h并赋值为10亿*3*10L，输出h
		 *   声明长整型变量i并赋值为10亿L*3*10，输出i
		 *   声明长整型变量j并赋值为
		 *     System.currentTimeMillis()，输出j
		 * 3.声明浮点型变量k和l，并分别赋值为3.0和2.9
		 *     输出k-l的值
		 */
		
		
		
		
		/*
		//3.double:浮点型，8个字节，很大很大很大
		double a=3.14159; //3.14159为浮点型直接量，默认为double型
		float b=3.14F; //3.14F为float的直接量
		
		//double运算时会有舍入误差，所以精确运算场不能用
		double c=6.0;
		double d=4.9;
		System.out.println(c-d); //1.0999999999996，舍入误差
		*/
		
		/*
		//2.long:长整型，8个字节，很大很大很大
		long a=250L; //250L为长整型直接量
		//long b=10000000000; //编译错误，100亿默认为int型，但超范围了
		long c=10000000000L; //100亿L为long型
		
		//运算时有可能溢出建议第一个数字后加L
		long d=1000000000*2*10L;
		System.out.println(d); //200亿
		long e=1000000000*3*10L;
		System.out.println(e); //肯定不是300亿
		long f=1000000000L*3*10;
		System.out.println(f); //300亿
		
		//获取自1970.1.1零时到此时此刻的毫秒数
		long g=System.currentTimeMillis();
		System.out.println(g);
		*/
		
		/*
		//1.int:整型，4个字节，-21个多亿到21个多亿
		int a=250; //250为整型直接量，默认为int型
		//int b=10000000000; //编译错误，100亿默认为int型，但超范围了
		//int c=5.6; //编译错误，数据类型不匹配
		
		//整数相除，结果还是整数，小数位无条件舍弃
		System.out.println(5/2); //2，小数位舍弃了
		System.out.println(2/5); //0，小数位舍弃了
		System.out.println(5.0/2); //2.5
		
		int d=2147483647;
		d=d+1;
		System.out.println(d); //溢出了，是需要避免的
		*/
		
	}
}


















