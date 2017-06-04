package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写字符串
 * @author adminitartor
 *
 */
public class RandomAccessFileDemo4 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.txt","rw"	
			);
		
		String str = "我爱达内苍老师";
		/*
		 * String提供了将当前字符串转换为
		 * 字节的方法
		 * byte[] getBytes()
		 * 将当前字符串按照默认字符集转换
		 * 
		 * byte[] getBytes(String csn)
		 * 将当前字符串按照给定的字符集转换
		 * 字符集的名字不区分大小写。
		 */
		byte[] data = str.getBytes("GBK");
		
		raf.write(data);
		
		System.out.println(
			"pos:"+raf.getFilePointer()
		);
		
		raf.seek(0);	
		byte[] buf = new byte[10];
		int len = raf.read(buf);
		/*
		 * 将给定字节数组中的指定范围内的字节按照
		 * 按照给定的字符集转换为字符串
		 */
		String s = new String(
			buf,"GBK"
		);
		System.out.println(s);		
		
		raf.close();
	}
}






