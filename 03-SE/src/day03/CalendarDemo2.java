package day03;

import java.util.Calendar;

/**
 * Calendar提供了获取各个时间分量的值的方法
 * @author adminitartor
 *
 */
public class CalendarDemo2 {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		//获取年?
		int year = calendar.get(Calendar.YEAR);
		System.out.println("year:"+year);
		//获取月? 月从0开始。即:0表示1月
		int month = calendar.get(Calendar.MONTH)+1;
		System.out.println("month:"+month);
		//获取日
		/*
		 * 和天相关的时间分量:
		 * DATE,DAY_OF_MONTH是一致的，表示月中的天
		 * DAY_OF_YEAR是表示年中的天
		 * DAY_OF_WEEK是表示周中的天
		 */
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"-"+month+"-"+day);
		
		int days = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("今天是今年的第:"+days+"天");
		/*
		 * 一周的第一天是周日
		 */
		int dow = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String[] data = {"日","一","二","三","四","五","六"};
		System.out.println("周"+data[dow]);
		/*
		 * HOUR,HOUR_OF_DAY
		 */
		
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		System.out.println(h+":"+m+":"+s);
	}
}