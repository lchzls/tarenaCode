package day07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件复制操作
 * @author adminitartor
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 使用FIS读取源文件，使用FOS向目标文件
		 * 中写数据。
		 * 依次从源文件中读取字节然后写入目标文件
		 * 完成复制操作。
		 */
		FileInputStream fis
			= new FileInputStream("music.mp3");
		
		FileOutputStream fos
			= new FileOutputStream("music_cp2.mp3");
		byte[] buf = new byte[1024*10];
		int len = -1;
		while((len = fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		System.out.println("复制完毕!");
		fis.close();
		fos.close();
	}
}






