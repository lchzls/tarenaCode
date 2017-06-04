package day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader
 * 字符输入流
 * 
 * 除了ISR与OSW之外的字符流，大部分都只处理其他
 * 字符流。但是低级流都是字节流,这时若希望用一个
 * 字符流来处理字节流是就产生了冲突。
 * 所以可以通过创建ISR或OSW来处理字节流，而ISR和
 * OSW本身是字符流，所以可以使得其他字符流得以处理
 * 该流。
 * ISR与OSW相当于是联系字节流与字符流的纽带，类似
 * 与转换器的效果。
 * @author adminitartor
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("osw.txt");

		InputStreamReader isr
			= new InputStreamReader(fis);
		
		/*
		 * int read()
		 * 一次读取一个字符，若返回值为-1则表示
		 * 读到末尾
		 */
//		int d = -1;
//		while((d = isr.read())!=-1){
//			System.out.print((char)d);
//		}
		
		int len = -1;
		char[] c = new char[100];
		while((len = isr.read(c))!=-1){
			System.out.println(
				String.valueOf(c, 0, len)
			);
		}
		
		isr.close();
	}
}






