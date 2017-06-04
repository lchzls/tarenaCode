package day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现电子表功能
 * 每秒钟输出一次当前系统时间，格式为:
 * 15:29:55
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"HH:mm:ss"
			);		
		while(true){
			System.out.println(
				sdf.format(new Date())
			);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}






