package day05;
/**
 * 使用该类来测试作为Map中的key元素的equals与
 * hashcode方法的重写准则
 * API手册上有明确说明，当我们要重写一个类的equals
 * 方法时就应当连同重写hashcode方法。并且他们之间
 * 的重写应当遵循:
 * 一致性:当两个对象equals比较为true时，那么hashcode
 *       方法返回的数字必须相同，反过来虽然不是强制的
 *       但是尽量保证两个对象hashcode若相同，equals
 *       比较也为true,否则在HashMap中会产生链表，影响
 *       HashMap查询性能
 * 稳定性:hashcode返回的数字在当前对象参与equals比较
 *       的属性值没有发生改变的前提下，多次调用返回的
 *       数字不应当改变。      
 * @author adminitartor
 *
 */
public class Key {
	private int x;
	private int y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}







