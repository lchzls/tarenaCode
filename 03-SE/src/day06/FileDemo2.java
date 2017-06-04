package day06;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建完文件
 * @author adminitartor
 *
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建demo.txt文件
		 * 不写"./"默认就是在当前目录下
		 */
		File file = new File("demo.txt");
		/*
		 * 判断File表示的文件或目录是否真实存在
		 */
		if(!file.exists()){
			file.createNewFile();
			System.out.println("创建完毕");
		}else{
			System.out.println("该文件已存在!");
		}
	}
}








