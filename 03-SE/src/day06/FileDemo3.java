package day06;

import java.io.File;

/**
 * 删除文件
 * @author adminitartor
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * 将当前目录中的demo.txt文件删除
		 */
		File file = new File("demo.txt");
		if(file.exists()){
			file.delete();
			System.out.println("已删除!");
		}else{
			System.out.println("该文件不存在!");
		}
	}
}





