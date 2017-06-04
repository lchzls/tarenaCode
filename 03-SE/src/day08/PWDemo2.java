package day08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * PW处理其他流
 * @author adminitartor
 *
 */
public class PWDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 向文件pw1.txt中写出内容
		 */
		FileOutputStream fos
			= new FileOutputStream("pw1.txt");
		/*
		 * PrintWriter构造方法传入字节流的话，
		 * 不能指定字符集。
		 */
//		PrintWriter pw
//			= new PrintWriter(fos);
		/*
		 * 若希望指定字符集，需要在中间使用
		 * OutputStreamWriter
		 */
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"GBK");
		PrintWriter pw
			= new PrintWriter(osw);
		
		pw.println("啦啦啦");
		pw.println("哈哈哈");
		System.out.println("写出完毕!");
		pw.close();
	}
}









