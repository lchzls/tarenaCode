package day08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 自动行刷新
 * 当PW处理的是一个流时，构造方法允许传入第二个
 * 参数，该参数为一个boolean值，当该值为true时
 * 则具有自动行刷新功能，即:每当使用println方法
 * 写出一行字符串时会自动flush
 * @author adminitartor
 *
 */
public class PWDemo3 {
	public static void main(String[] args) throws IOException {
		/*
		 * 记事本功能
		 */
		Scanner scanner = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(
			new OutputStreamWriter(
				new FileOutputStream("E:\\note.txt")	
			),true	
		);	
		System.out.println("请开始输入内容");
		while(true){
			
			String line = scanner.nextLine();
			if("exit".equals(line)){
				System.out.println("再见!");
				break;
			}
			/*
			 * 具有自动行刷新的pw在使用println
			 * 方法是会自动flush
			 */
			pw.println(line);
		}
		pw.close();
	}
}






