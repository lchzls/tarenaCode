package day06;

import java.io.File;

/**
 * 创建多级目录
 * @author adminitartor
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		/*
		 * 在当前目录下创建a/b/c/d/e/f目录
		 */
		File dir = new File(
			"a"+File.separator+
			"b"+File.separator+
			"c"+File.separator+
			"d"+File.separator+
			"e"+File.separator+
			"f"
		);
		if(!dir.exists()){
			/*
			 * 该方法会将所有不存在的父目录一同
			 * 创建出来
			 */
			dir.mkdirs();
			System.out.println("创建完毕!");
		}else{
			System.out.println("该目录已经存在!");
		}
	}
}





