package day03;

import java.util.Date;

/**
 * java.util.Date
 * 该类的每一个实例用于表示一个具体的时间点
 * 内部维护一个long值，该值为1970年元旦到该Date
 * 表示的时间之间所经过的毫秒。
 * Date因为设计存在缺陷，所以大部分方法被修饰为过时
 * 的，不再建议使用。所以，现在仅用其表示一个时间
 * 
 * @author adminitartor
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		//表示当前系统时间
		Date date = new Date();
		/*
		 * Date重写了toString方法
		 * 但是显示的日期格式对非英语地区不十分
		 * 友好。
		 */
		System.out.println(date);
		//获取Date内部维护的毫秒值
		long time = date.getTime();
		System.out.println(time);
		
		time += 1000*60*60*24;
		
		date.setTime(time);
		System.out.println(date);
		
	}
}
