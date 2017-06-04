package day06;

import java.io.File;

/**
 * 删除目录
 * @author adminitartor
 *
 */
public class FileDemo6 {
	public static void main(String[] args) {
		File dir = new File("demo");
		if(dir.exists()){
			/*
			 * 删除目录要求该目录必须是一个空目录
			 */
			dir.delete();
			System.out.println("删除完毕!");
		}
	}
}




