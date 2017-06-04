package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile读写基本类型数据
 * 以及基于指针的读写操作
 * @author adminitartor
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile("raf.dat","rw");		
		/*
		 * RAF总是在指针当前位置进行读写字节，并且
		 * 无论进行了读还是写一个字节后，指针都会自动
		 * 向后移动到下一个字节的位置。
		 * 默认创建出来RAF时，指针的位置为0，即：文件
		 * 的第一个字节的位置。
		 */
		//获取当前指针的位置
		long pos = raf.getFilePointer();
		System.out.println("pos:"+pos);
	
		/*
		 * 写入一个int最大值
		 * 01111111 11111111 11111111 11111111
		 *                            vvvvvvvv
		 * 01111111 11111111 11111111 11111111
		 */
		int imax = Integer.MAX_VALUE;
		raf.write(imax>>>24);		
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//1		
		raf.write(imax>>>16);
		raf.write(imax>>>8);
		raf.write(imax);
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//4
		/*
		 * 一次写出4个字节，将int值写出
		 */
		raf.writeInt(imax);
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//8
		raf.writeLong(123L);
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//16
		
		
		raf.writeDouble(123.123);
		
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//24
		
		System.out.println("写出完毕!");
		
		/*
		 * void seek(long pos)
		 * 将指针移动到指定位置
		 */
		//将指针移动到文件开始处
		raf.seek(0);
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//0
		/*
		 * int readInt()
		 * 连续读取4个字节，并转换为对应的int
		 * 值返回，若在读取的4个字节的过程中
		 * 读取到文件末尾，这回抛出EOFException
		 */
		int max = raf.readInt();
		System.out.println(max);
		
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//4
		
		//读取double
		raf.seek(16);
		double d = raf.readDouble();
		System.out.println(d);
		System.out.println(
			"pos:"+raf.getFilePointer()
		);//24
		
		//读取long值
		raf.seek(8);
		long l = raf.readLong();
		System.out.println(l);
		
		d = raf.readDouble();
		System.out.println(d);
		
		raf.close();
		
	}
}









