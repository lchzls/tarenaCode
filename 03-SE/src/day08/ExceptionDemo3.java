package day08;

import java.io.FileOutputStream;

/**
 * IO中使用异常捕获机制
 * 
 * 面试题:
 * 分别说明
 * final,finally,finalize是什么?
 * 
 * finalize是Object中定义的方法，当一个对象即将
 * 被GC释放时，GC会调用该方法。则意味着该方法被执
 * 行完毕后，该对象即被释放。
 * @author adminitartor
 *
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream("fos.txt");
			fos.write("hello".getBytes());
		}catch(Exception e){
			System.out.println("写出失败!");
		}finally{
			if(fos!=null){
				try{
					fos.close();
				}catch(Exception e){

				}
			}
		}
	}
}






