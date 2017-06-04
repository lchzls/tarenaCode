package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 若希望提高读写效率，需要提高每次读写的数据量
 * 来减少读写次数从而达到提高读写效率的目的。
 * @author adminitartor
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile("mv.mp4","r");
	
		RandomAccessFile desc
			= new RandomAccessFile("mv_cp2.mp4","rw");
	
		/*
		 * int read(byte[] d)
		 * 一次性读取给定的数组总长度的字节量，
		 * 并存入到该数组中，返回值为实际读取到的
		 * 字节量,若返回值为-1，则表示读取到了文件
		 * 末尾（EOF end of file）
		 */
		int len = -1;//记录每次读到的实际字节量
		byte[] buf = new byte[1024*10];//10k
		
		long start = System.currentTimeMillis();
		while((len = src.read(buf))!=-1){
			/*
			 * void write(byte[] d)
			 * 将给定的字节数组中的所有字节一次性
			 * 写入到文件中
			 * 
			 * void write(byte[] d,int offset,int len)
			 * 将给定的字节数组中从下标为offset处的字节开始的
			 * 连续len个字节一次性写入到文件中
			 */
			desc.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!耗时:"+(end-start)+"ms");
		src.close();
		desc.close();
	}
}





