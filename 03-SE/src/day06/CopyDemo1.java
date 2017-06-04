package day06;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author adminitartor
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile("mv.mp4","r");
		
		RandomAccessFile desc
			= new RandomAccessFile("mv_cp.mp4","rw");
		long start = System.currentTimeMillis();
		int d = -1;
		while((d = src.read())!=-1){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!耗时:"+(end-start)+"ms");
		src.close();
		desc.close();
	}
}








