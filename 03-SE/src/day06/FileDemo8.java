package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取一个目录中的部分子项
 * File支持一个重载的listFiles方法，要求传入
 * 一个文件过滤器，这样只会返回该目录中满足该
 * 过滤器要求的子项。
 * 
 * @author adminitartor
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		/*
		 * 仅获取当前目录中的所有文件
		 */
		File dir = new File(".");
		MyFilter filter = new MyFilter();
		File[] subs = dir.listFiles(filter);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}

class MyFilter implements FileFilter{
	public boolean accept(File file) {
		System.out.println(
			"正在过滤:"+file.getName()
		);		
		return file.isFile();
		//return file.getName().startWith(".");
	}
	
}









