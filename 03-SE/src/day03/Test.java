package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 程序启动后要求用户输入自己的生日，
 * 格式:yyyy-MM-dd
 * 然后经过计算，输出到今天为止活了多少天?
 * 然后在经过计算，输出其出生10000天的纪念日，
 * 格式为: yyyy年MM月dd日
 * @author adminitartor
 *
 */
public class Test {
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
			"请输入您的生日:(yyyy-mm-dd)"
		);
		String birthStr = scanner.nextLine();
		
		//转换为Date
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy-MM-dd"	
			);
		//生日
		Date birth = sdf.parse(birthStr);	
		//今天
		Date now = new Date();
		//从生日到今天所经过的毫秒
		long time = now.getTime()-birth.getTime();
		//换算成天
		time = time/1000/60/60/24;
		System.out.println("恭喜您，已经活了:"+time+"天，请继续保持!");
		
		
		//计算10000天的纪念日
		//生日的毫秒
		time = birth.getTime();
		//加上10000天的毫秒
		time = time+1000L*60*60*24*10000;
		//10000天以后的日期
		birth.setTime(time);
		//转换为字符串
		String str = sdf.format(birth);
		System.out.println("您出生10000天的纪念日为:"+str);
	}
}






