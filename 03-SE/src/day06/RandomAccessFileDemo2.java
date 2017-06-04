package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取字节
 * @author adminitartor
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","r"
			);
		/*
		 * int read()
		 * 从文件中指针当前位置读取该字节，并以
		 * 10进制的数字形式返回。
		 * 若返回值为-1.则表示读取到了文件末尾
		 * 
		 * 00000000 00000000 00000000 11111111
		 */
		int d = raf.read();
		System.out.println(d);//97
		
		d = raf.read();
		System.out.println(d);//98
		
		d = raf.read();
		System.out.println(d);//99
		
		d = raf.read();
		System.out.println(d);//-1
		raf.close(); 
	}
}







