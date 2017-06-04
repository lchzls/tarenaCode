package day06;

import java.io.File;

/**
 * 创建一个目录
 * @author adminitartor
 *
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建目录demo
		 */
		File dir = new File("demo");
		if(!dir.exists()){
			dir.mkdir();
			System.out.println("创建完毕!");
		}else{
			System.out.println("该目录已经存在!");
		}
	}
}






