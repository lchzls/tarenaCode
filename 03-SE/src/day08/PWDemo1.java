package day08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * 内部维护缓冲区(字符数组)，读写字符效率高
 * 并且可以按行读写字符串
 * BufferedWriter,BufferedReader
 * 
 * java.io.PrintWriter
 * 常用的缓冲字符输出流，内部自动处理BufferedWriter
 * 来完成缓冲操作，并且PrintWriter具有自动行刷新
 * 功能
 * @author adminitartor
 *
 */
public class PWDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * PrintWriter提供了丰富的构造方法
		 * 其中提供了可以针对文件写出操作的
		 * 构造方法:
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 */
		PrintWriter pw
			= new PrintWriter("pw.txt","GBK");
	
		pw.println("锄禾日当午");
		pw.println("汗滴禾下土");
		pw.println("谁知盘中餐");
		pw.println("粒粒皆辛苦");
		System.out.println("写出完毕!");
		pw.close();
	}
}










