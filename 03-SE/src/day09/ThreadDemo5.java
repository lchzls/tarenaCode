package day09;
/**
 * 查看线程信息的相关方法
 * @author adminitartor
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		//获取运行main方法的线程
		Thread t = Thread.currentThread();
		
		//查看线程名
		String name = t.getName();
		System.out.println("name:"+name);
		
		//查看唯一标示
		long id = t.getId();
		System.out.println("id:"+id);
		
		//查看优先级
		int priority = t.getPriority();
		System.out.println("priority:"+priority);
		
		//是否处于活动状态
		boolean isAlive = t.isAlive();
		System.out.println("isAlive:"+isAlive);
		
		//是否为守护线程
		boolean isDaemon = t.isDaemon();
		System.out.println("isDaemon:"+isDaemon);
		
		//是否被中断了
		boolean isInterrupted = t.isInterrupted();
		System.out.println("isInterrupted:"+isInterrupted);
	}
}







