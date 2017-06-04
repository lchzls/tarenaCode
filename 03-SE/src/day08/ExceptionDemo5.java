package day08;
/**
 * 异常常用方法
 * @author adminitartor
 *
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			//输出异常堆栈信息(执行过程)
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
		System.out.println("程序结束了");
	}
}
