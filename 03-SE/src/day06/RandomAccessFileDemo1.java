package day06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 用于读写文件数据。其基于指针对文件进行读写。
 * 创建RandomAccessFile有两种常用模式:
 * 1:"r",即只读模式，仅对文件数据进行读取操作
 * 2:"rw",即读写模式，对文件数据可以编辑。 
 * @author adminitartor
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * RandomAccessFile(File f,String mode)
		 * RandomAccessFile(String path,String mode)
		 * 
		 * 其中mode是操作模式："r","rw"
		 * 
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","rw"	
			);
		/*
		 * void write(int d)
		 * 写出1个字节，写出的是该整数对应的2进制
		 * 中的“低八位”
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00000001
		 */
		raf.write(97);//01100001
		raf.write(98);//01100010
		raf.write(99);//01100011
		/*
		 * raf.dat中的文件数据有3个字节了，内容
		 * 为:
		 * 01100001 01100010 01100011
		 * 
		 */
		
		
		System.out.println("写出完毕!");
		/*
		 * 读写完毕后关闭raf
		 */
		raf.close();
	}
}











