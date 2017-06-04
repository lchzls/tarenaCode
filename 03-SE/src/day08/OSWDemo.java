package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java根据读写数据单位不同，将流分为:
 * 字节流与字符流
 * 字节流的最小读写单位为1个字节
 * 字符流的最小读写单位为1个字符
 * 
 * 字符流虽然是以字符为单位，但是底层实际上还是
 * 要以字节形式读写，所以字符流天生就具备将字节
 * 转换为字符或字符转换为字节的能力。所以所有的
 * 字符流都是高级流。方便我们读写字符数据。无需
 * 再关心字符与字节的相互转换了。
 * 
 * @author adminitartor
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 向文件osw.txt中写入字符串
		 */
		FileOutputStream fos
			= new FileOutputStream("osw.txt");
		/*
		 * OutputStreamWriter的常用构造方法:
		 * OutputStreamWriter(OutputStream out)
		 * 
		 * OutputStreamWriter(OutputStream out,String csn)
		 * 将给定的字节输出流转换为字符流的同时，指定
		 * 通过当前字符输出流写出的字符数据以何种字符集
		 * 转换为字节。
		 */
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"GBK");
		
		osw.write("苍老师和小泽老师都是我们的好老师!");
		osw.write("喜欢小泽老师的清新与苍老师的老练!");
		System.out.println("写出完毕!");
		osw.close();
	}
}






