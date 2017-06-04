package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * String->Date
 * 
 * @author adminitartor
 *
 */
public class SimpleDateFormatDemo2 {
	public static void main(String[] args) throws ParseException {
		String str = "2008-08-08 20:08:08";
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"	
			);
		/*
		 * Date parse(String str)
		 * 将给定的字符串按照SDF指定的日期格式字符串
		 * 解析为Date
		 */
		Date date = sdf.parse(str);
		System.out.println(date);
	}
}







