package day09;
/**
 * 线程优先级
 * 线程对于线程调度的工作是不可控的。线程只能被动
 * 的被分配时间片，不能主动获取。线程调度也尽可能
 * 的将时间片的次数均匀的分配给所有并发运行的线程。
 * 但是不保证"一人一次"。
 * 线程可以通过改变线程的优先级来改变获取CPU时间片
 * 的次数。
 * 理论上，线程优先级越高的线程，获取时间片的次数就
 * 越多。
 * 线程优先级有10个等级分别用整数1-10表示，1最小
 * 10最大，5为默认值。
 * Thread提供了常量表示了最大优先级，最小优先级
 * 与默认优先级，分别是:MAX_PRIORITY,MIN_PRIORITY
 * NORM_PRIORITY
 * @author adminitartor
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread nor = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("nor");
				}
			}
		};
		
		max.setPriority(Thread.MAX_PRIORITY);
		min.setPriority(Thread.MIN_PRIORITY);
		
		min.start();
		nor.start();
		max.start();
	}
}








