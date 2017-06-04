package day03;

import java.util.Calendar;

/**
 * 获取某一个时间分量所允许的最大值
 * @author adminitartor
 *
 */
public class CalendarDemo4 {
	public static void main(String[] args) {
		Calendar calendar 
			= Calendar.getInstance();
		//查看当月共多少天?
		int days = calendar.getActualMaximum(
			Calendar.DAY_OF_MONTH
		);
		System.out.println(days);
		//今年总共多少天?
		days = calendar.getActualMaximum(
			Calendar.DAY_OF_YEAR	
		);
		System.out.println(days);
	}
}




