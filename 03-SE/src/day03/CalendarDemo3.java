package day03;

import java.util.Calendar;

/**
 * 设置时间分量
 * @author adminitartor
 *
 */
public class CalendarDemo3 {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		/*
		 * 表示2008-08-08 20:08:08
		 */
		//设置年
		calendar.set(Calendar.YEAR, 2008);
		//设置月
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		//设置日
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND, 8);
		//超出某个时间分量允许最大值时，会自行进位
		calendar.set(Calendar.DAY_OF_MONTH, 32);
		
		System.out.println(calendar.getTime());
		
	}
}




