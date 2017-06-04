package day10;
/**
 * 互斥锁
 * synchronized修饰不同的代码，但是只要同步监视器
 * 对象相同，那么这些代码之间就具有了互斥效果。
 * 即:多个线程不能同时访问这些代码。
 * @author adminitartor
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread(){
			public void run(){
				boo.methodA();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				boo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在执行A方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t+"执行A方法完毕");
	}
	public synchronized void methodB(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在执行B方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t+"执行B方法完毕");
	}
}






