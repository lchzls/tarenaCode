package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 该类可以根据一个指定的日期格式将Date与String
 * 之间进行相互转换。
 * @author adminitartor
 *
 */
public class SimpleDateFormatDemo1 {
	public static void main(String[] args) {
		/*
		 * Date->String
		 */
		Date now = new Date();
		System.out.println(now);
		/*
		 * 2016-08-24 09:55:23
		 * yyyy-MM-dd HH:mm:ss
		 */
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"
			);
		/*
		 * String format(Date date)
		 * 将给定的Date所表示的时间按照当前SDF
		 * 指定的日期格式转换为字符串。
		 */
		String str = sdf.format(now);
		System.out.println(str);
	}
}






