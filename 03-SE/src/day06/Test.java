package day06;

import java.io.File;

/**
 * 
 * 定义一个方法，可以删除指定的文件或目录
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File("a");
		delete(dir);
	}
	/**
	 * 将给定的File表示的文件或目录删除
	 * @param file
	 */
	public static void delete(File file){
		/*
		 * 若是目录，需要先将该目录中的所有内容
		 * 删除
		 */
		if(file.isDirectory()){
			//先删除其所有子项
			File[] subs = file.listFiles();
			for(File sub : subs){
				//递归调用
				delete(sub);
			}			
		}
		file.delete();
	}
}

/*
 * 1:编写一段代码，要求1+2+3+4+....100
 *   每次计算后输出一次结果。
 *   代码不得超过20行
 *   在代码中不得出现for,while关键字
 *   
 * 2:一个人去买汽水，1块钱买一瓶汽水，3个瓶盖可以
 *   换一瓶汽水，2个空瓶也可以换一瓶汽水，
 *   问:20块钱能喝多少平汽水
 *   编写一段代码完成上述需求。  
 * 
 */













