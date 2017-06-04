package day09;
/**
 * 线程的创建方式有两种
 * 方式一:继承thread并重写run方法来定义线程任务。
 * @author adminitartor
 *
 */
public class ThreadDemo1 {
	
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程要调用start方法，而不要直接
		 * 调用run方法。
		 * start方法会很快执行完毕，作用是将线程
		 * 纳入到线程调度，使得当前线程进入runnable
		 * 状态,并发运行。当该线程第一次获取CPU时间
		 * 后会自动调用run方法开始工作。
		 */
		t1.start();
		t2.start();
	}
}
/*
 * 第一种创建线程的方式存在两个不足:
 * 1:由于java是单继承的，这就导致当前类若继承了
 *   Thread就不能再继承其他类，这在实际开发中会
 *   出现继承冲突，因为经常会为了复用一个类的方法
 *   而去继承该类，但是由于已经继承线程，导致问题。
 * 2:线程内部重写run方法定义了线程任务，导致当前
 *   线程与执行的任务有一个耦合关系，这就导致线程
 *   的重用性变得很差。  
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){			
			System.out.println("你是谁啊？");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){			
			System.out.println("我是查水表的!");
		}
	}
}








