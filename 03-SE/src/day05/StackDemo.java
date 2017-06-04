package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 用于存放一组元素，元素存取必须遵循先进后出
 * 原则。
 * 使用栈通常为了解决有"后退"功能的需求中。
 * 栈可以使用双端队列实现。双端队列Deque,两端
 * 都可以进出队的队列。当仅从一段进出队时，就
 * 实现了栈的效果。
 * 
 * @author adminitartor
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack
			= new LinkedList<String>();
		/*
		 * void push(E e)
		 * 向栈顶"压入"元素，入栈操作
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");		
		System.out.println(stack);
		/*
		 * E pop()
		 * 获取栈顶元素，并做出栈操作，若仅想
		 * 引用，还是使用peek
		 */
		String str = stack.pop();
		System.out.println(str);
		System.out.println(stack);
		
	}
}







