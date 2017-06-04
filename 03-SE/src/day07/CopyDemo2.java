package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流,作用:提高读写效率 缓冲流是一对高级流，使用它们进行读写的效率 是比较高的。
 * 
 * @author adminitartor
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis 
			= new FileInputStream("music.mp3");
		//将BIS装到FIS上可以提高读取文件效率
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		FileOutputStream fos 
			= new FileOutputStream("music_cp3.mp3");
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);		
		int d = -1;
		/*
		 * 缓冲流内部维护了一个缓冲区，当我们调用
		 * 下面read()方法读取一个字节时，实际上缓冲
		 * 流会让fis读取一组字节并存入到缓冲流自身内部
		 * 的字节数组中，然后将第一个字节返回。当我们
		 * 再次调用read()方法读取一个字节时，缓冲流
		 * 会直接将数组中第二个字节返回，以此类推，直到
		 * 该数组中所有字节都被读取过后才会再次读取一组
		 * 字节。所以实际上还是通过提高每次读取数据的数
		 * 量来减少读取的次数提高的读取效率
		 * 
		 */
		while ((d = bis.read()) != -1) {
			bos.write(d);
		}
		System.out.println("复制完毕!");
		bis.close();
		bos.close();
	}
}
