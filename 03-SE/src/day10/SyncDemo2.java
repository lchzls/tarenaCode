package day10;
/**
 * 有效的缩小同步范围可以在保证并发安全的前提下
 * 提高并发效率
 * @author adminitartor
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy(){		
		try {
			Thread t = Thread.currentThread();
			System.out.println(t+"正在挑选衣服...");
			Thread.sleep(5000);
			/*
			 * 同步块
			 * synchronized(同步监视器){
			 * 		需要同步的代码片段...
			 * }
			 * 
			 * 同步块可以更精确地控制同步的范围。
			 * 但是若希望保证多个线程不能同时执行需要
			 * 同步的代码片段，就要求多个线程看到的同步
			 * 监视器(即:一个上锁的对象)必须是同一个！
			 * 
			 * 对于成员方法而言，通常使用this作为同步
			 * 监视器对象即可。
			 * 
			 */
			synchronized (this) {
				System.out.println(t+"正在试衣服...");
				Thread.sleep(5000);
			}
			
			
			System.out.println(t+"结账离开");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
















