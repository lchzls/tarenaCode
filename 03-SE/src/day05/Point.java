package day05;
/**
 * 该类用于测试作为集合元素的排序
 * @author adminitartor
 *
 */
public class Point implements Comparable<Point>{
	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	/**
	 * 当实现了Comparable接口后，就需要重写
	 * compareTo方法，该方法的作用是判断当前
	 * 对象(this)与参数给定的对象比较大小。
	 * 如果:
	 * 返回值>0:当前对象比参数给定的对象大
	 * 返回值<0:当前对象比参数给定的对象小
	 * 返回值=0:两个对象相等
	 */
	public int compareTo(Point o) {
		/*
		 * 判断标准为点到原点的距离长的大
		 */
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
	
	
}
