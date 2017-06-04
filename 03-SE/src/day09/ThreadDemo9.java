package day09;
/**
 * 线程提供了一个方法
 * void join()
 * 该方法允许一个线程调用另一个线程的join方法，使
 * 的调用方法的线程进入阻塞状态，直到join方法所属
 * 对象结束后才解除阻塞继续执行。
 * 例如A线程调用了B线程的join方法
 * 那么A线程进入阻塞状态，直到B线程结束，A才会解除
 * 阻塞继续运行。
 * @author adminitartor
 *
 */
public class ThreadDemo9 {
	//表示图片是否下载完毕
	public static boolean isFinish = false;
	
	public static void main(String[] args) {
		
		//下载线程
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i=1;i<=100;i++){
					System.out.println("down:已完成"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down:图片下载完毕!");
				isFinish = true;
			}
		};
		
		//显示图片的线程
		Thread show = new Thread(){
			public void run(){
				System.out.println("show:开始显示图片..");
				/*
				 * 先等待下载线程将图片下载完毕
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!isFinish){
					throw new RuntimeException("图片没有下载完毕!");
				}
				System.out.println("show:显示图片完毕!");
			}
		};
		
			
		download.start();
		show.start();
	}
}








