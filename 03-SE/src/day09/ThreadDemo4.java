package day09;
/**
 * 线程常用的API
 * 
 * static Thread currentThread
 * 获取运行当前方法的线程。
 * 
 * java中所有代码都是靠线程运行的，main方法也是
 * 当启动程序时，OS会创建一个进程运行虚拟器，进程
 * 启动起来会自动创建一个线程来运行main方法。
 * @author adminitartor
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		/*
		 * 获取运行main方法的线程
		 */
		Thread main = Thread.currentThread();
		System.out.println(
			"运行main方法的线程是:"+main
		);
		dosome();
		
		Thread t = new Thread(){
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println("自定义线程:"+t);
				dosome();
			}
		};
		t.start();
	}
	
	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是:"+t);
	}
}







