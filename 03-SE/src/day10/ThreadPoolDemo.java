package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 主要解决两个问题:
 * 1:控制线程数量
 * 2:重用线程
 * 
 * 当遇到需要大量任务需要创建大量线程时，或者遇到
 * 频繁创建销毁线程的时候都应当使用线程池来维护
 * 线程。
 * 大量线程并发运行会导致CPU过度切换拖慢系统响应，
 * 严重时可能导致系统瘫痪。
 * 
 * @author adminitartor
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		//固定大小线程
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		/*
		 * 指派5个任务
		 */
		for(int i=1;i<=5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"正在执行任务");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println(t+"被中断了!");
					}
					System.out.println(t+"执行任务完毕");
				}
			};
			System.out.println("指派第"+i+"个任务");			
			threadPool.execute(runn);
		}
		
		/*
		 * 停止线程池的方法:
		 * shutdown():
		 * 当线程池中的所有任务运行完毕后停止。
		 * 
		 * shutdownNow()
		 * 立刻停止线程池，线程池中的所有线程会立即
		 * 被中断。
		 *            
		 */
//		threadPool.shutdown();
		threadPool.shutdownNow();
		System.out.println("停止线程池!");
		
	}
}












