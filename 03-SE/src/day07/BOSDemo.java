package day07;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲输出流写出数据
 * @author adminitartor
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("bos.txt");
	
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		/*
		 * 通过缓冲输出流写出的字节并不会立刻被
		 * 写入文件，会先存入其内部的字节数组，直
		 * 到该数组满了，才会一次性写出所有数据。
		 * 这样做等同于提高写出数据量减少写出次数
		 * 提高写出效率。
		 */
		bos.write("我爱北京天安门".getBytes());
		System.out.println("写出完毕!");
		/*
		 * flush方法可以强制将缓冲区已有数据一次性
		 * 写出，这样可以提高及时性，但是频繁操作
		 * 会导致写出次数提高降低写出效率
		 */
//		bos.flush();
		
		bos.close();
	}
}








