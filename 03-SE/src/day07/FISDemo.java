package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 文件字节输入流，是一个低级流，可以从指定
 * 文件中读取字节
 * @author adminitartor
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("fos.txt");
		
		byte[] data = new byte[50];
		int len = fis.read(data);
		String str = new String(
			data,0,len,"UTF-8"
		);
		System.out.println(str);
		
		fis.close();
	}
}









