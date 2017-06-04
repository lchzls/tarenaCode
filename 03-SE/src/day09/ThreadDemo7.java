package day09;
/**
 * 线程提供了一个静态方法
 * static void sleep(long ms)
 * 使运行当前方法的线程进入阻塞状态指定毫秒，当
 * 超时后线程回到runnable状态等待再次分配时间片
 * 继续运行。
 * 通常使用sleep做周期性循环操作的间隔时间使用
 * @author adminitartor
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		System.out.println("程序开始了");	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("程序结束了");
	}
}







