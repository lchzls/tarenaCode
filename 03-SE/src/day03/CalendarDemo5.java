package day03;

import java.util.Calendar;

/**
 * 使用Calendar计算时间
 * @author adminitartor
 *
 */
public class CalendarDemo5 {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		
		/*
		 * 查看3年1个月零2天以后那周的周一是哪天?
		 * 
		 * void add(int field,int value)
		 * 对指定的时间分量累加指定的值，若value
		 * 是负数，这是减去。
		 */
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		System.out.println(calendar.getTime());
		
		/*
		 * 要求用户输入一个日期，并对该日期进行
		 * 一系列的计算后，将计算后的日期再以
		 * 指定的个数输出给用户.
		 * 
		 * String--SimpleDateFormat-->Date
		 * Date-->Calendar
		 * 使用Calendar进行相应的计算
		 * Calendar-->Date
		 * Date--SimpleDateFormat-->String
		 * 
		 */
		
		
		
		
	}
}









