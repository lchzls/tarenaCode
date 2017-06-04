package day08;
/**
 * java异常捕获机制中的
 * try-catch
 * try块用来包含可能出错的代码片段
 * catch用来捕获try块中的代码出现的错误并解决
 * @author adminitartor
 *
 */
public class ExceptionDemo1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			String str = "a";
			/*
			 * 当JVM运行某句代码时发现了一个异常时，
			 * 就会实例化该异常的一个实例，并将程序
			 * 执行过程的完成报告设置进去，然后将该
			 * 异常抛出。
			 */
			System.out.println(str.length());
			System.out.println(str.charAt(0));
			System.out.println(Integer.parseInt(str));
			/*
			 * try块中的代码出现异常后就会跳出try块，所以
			 * try块中出现异常的代码行以下的代码都不会再被
			 * 运行。
			 * 若26行代码出错，那么下面的输出就不会执行!
			 */
			System.out.println("try代码最后一句!!");
			
		/*
		 * 针对try代码中出现的异常有不同解决手段
		 * 的，可以单独去捕获这些异常，并解决。
		 * 但需要注意，有集成关系的异常，一定是子类
		 * 异常在上，父类异常在下。	
		 */
		}catch(NullPointerException e){		
			System.out.println("出现了空指针!");	
		}catch(StringIndexOutOfBoundsException e){
			System.out.println("字符串下标越界了!");
		//最终应当捕获Exception，避免程序因额外异常闪退	
		}catch(Exception e){
			System.out.println("反正就是出了个错!");
		}
		System.out.println("程序结束了");
	}
}








