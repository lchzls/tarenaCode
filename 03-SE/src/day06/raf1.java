package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class raf1 {

	public static void main(String[] args) throws IOException {
	
			RandomAccessFile raf
			= new RandomAccessFile("raf1.dat","rw");
			raf.write(97);
			raf.close();	
	}
}
