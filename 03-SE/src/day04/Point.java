package day04;
/**
 * 泛型，JDK1.5后推出的一个新特性
 * 泛型又称为参数化类型，是将属性，方法参数，方法
 * 返回值类型的定义权交给了调用者，使得调用者在实际
 * 应用当前类时可以将实际类型指定以更满足其需求。
 * @author adminitartor
 *
 * @param <T>
 */
public class Point<T> {
	private T x;
	private T y;
	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
}
