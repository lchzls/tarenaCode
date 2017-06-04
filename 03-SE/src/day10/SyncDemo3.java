package day10;
/**
 * 静态方法上使用synchronized后，该方法为同步
 * 方法。静态方法由于所属类，所以一定具有同步效果
 * @author adminitartor
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final Foo f1 = new Foo();
		final Foo f2 = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				f1.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				f2.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在执行dosome方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t+"执行dosome方法完毕");
	}
}





