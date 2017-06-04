package day03;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类
 * 通常使用该类对时间进行操作
 * 常用实现类java.util.GregorianCalendar
 * @author adminitartor
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		/*
		 * 默认创建出来的Calendar的实现类表示
		 * 当前系统时间
		 */
		Calendar calendar 
			= Calendar.getInstance();
		/*
		 * toString重写了，但是不能直观反映
		 * 其表示的时间
		 */
		System.out.println(calendar);	
		
		/*
		 * Calendar -> Date
		 * Calendar提供了方法:
		 * Date getTime()
		 * 该方法会返回一个Date实例，该实例表示的
		 * 时间就是当前Calendar所表示的时间
		 */
		Date date = calendar.getTime();
		System.out.println(date);
		
		
		
		/*
		 * Date -> Calendar
		 * Calendart提供了方法:
		 * void setTime(Date date)
		 * 该方法可以使当前Calendar表示给定的
		 * Date所表示的时间。
		 */
		calendar.setTime(date);
		
	}
}







