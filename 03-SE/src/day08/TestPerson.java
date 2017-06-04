package day08;
/**
 * 测试异常抛出的解决
 * @author adminitartor
 *
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p = new Person();
		/*
		 * 当调用一个含有异常抛出声明的方法时
		 * 编译器要求必须处理该方法声明可能抛出
		 * 的异常。处理手段有两种:
		 * 1:使用try-catch捕获并解决
		 * 2:在当前方法上继续使用throws声明该
		 *   异常的抛出。
		 *   
		 * 永远不应在main方法上声明异常的抛出  
		 */
		try {
			p.setAge(1000);
	//	} catch (Exception e) {
		} catch (IllegalAgeException e) {
			
			e.printStackTrace();
		}
		System.out.println("年龄:"+p.getAge());
	}
}



