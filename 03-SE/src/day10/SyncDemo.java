package day10;

import javax.swing.plaf.synth.SynthViewportUI;

/**
 * 当多线程操作[同一]资源时，就会形成"抢"的现象，
 * 这会导致程序出现逻辑混乱，严重时会导致系统瘫痪。
 * 出现的原因在于，线程切换的时机不可控。
 * 这就是所谓的多线程并发安全问题。
 * 解决的办法是将"各干各的"变为"排队干"
 * @author adminitartor
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(
						getName()+":"+bean);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		t1.start();
		t2.start();
	}
}
class Table{
	private int beans = 20;
	/**
	 * 从桌子上取一个豆子
	 * 
	 * 当一个方法被synchronized修饰后，该方法
	 * 称为同步方法，即:多个线程不可能在同一时间
	 * 内访问方法内部，必须按顺序一个一个访问。
	 * 相当于排队执行方法，则就不会出现"抢"而导致
	 * 的混乱问题。
	 * 
	 * 在成员方法上使用synchronized修饰后，那么
	 * 同步监视器对象就是当前方法所属对象，即:
	 * 方法中看到的this.
	 * @return
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了!");
		}
		Thread.yield();//模拟到这里发生线程切换
		return beans--;
	}
}









