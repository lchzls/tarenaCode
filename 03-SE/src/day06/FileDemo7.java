package day06;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 * @author adminitartor
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录下的所有内容
		 */
		File dir = new File(".");
		/*
		 * boolean isFile()
		 * 判断当前File对象表示的是否为一个文件
		 * 
		 * boolean isDirectory()
		 * 判断是否表示的是一个目录
		 */
		if(dir.isDirectory()){
			/*
			 * File[] listFiles()
			 * 查看当前File表示的目录中的所有子项
			 * 每个子项以一个File对象表示。所有子项
			 * 存入一个File对象数组返回。
			 */
			File[] subs = dir.listFiles();
			for(File sub : subs){
				if(sub.isFile()){
					System.out.print("文件:");
				}else{
					System.out.print("目录:");
				}
				System.out.println(sub.getName());
			}
		}
	}
}








