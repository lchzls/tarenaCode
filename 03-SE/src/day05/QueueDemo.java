package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列，用于存放一组元素，但是队列对于存取要求
 * 必须遵循:先进先出原则
 * @author adminitartor
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue
			= new LinkedList<String>();		
		/*
		 * boolean offer(E e)
		 * 将给定元素做入队操作
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		
		/*
		 * E poll()
		 * 从队首获取元素，出队操作，取出后该元素
		 * 即从队列中被删除
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		/*
		 * E peek()
		 * 引用队首元素，同样可以获取队首元素，
		 * 但是并不会将该元素从队列中删除。
		 */
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		//迭代器遍历队列，元素不会减少
//		for(String s : queue){
//			System.out.println(s);
//		}
//		System.out.println(queue);
		
		while(queue.size()>0){
			String s = queue.poll();
			System.out.println(s);
		}
		System.out.println(queue);
	}
}







