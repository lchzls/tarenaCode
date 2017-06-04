package day02;
/**
 * 使用该类来测试Object方法以及重写原则
 * 
 * 表示直角坐标系上的一个点
 * @author adminitartor
 *
 */
public class Point {
	private int x;
	private int y;
	
	public Point(){
		
	}		
	
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
	/**
	 * 通常需要使用一个类的toString方法时，就应当
	 * 重写该方法。
	 * 
	 * 该方法返回一个字符串，该字符串没有具体格式
	 * 要求，但是原则上应当包含当前对象的属性信息。
	 * 
	 * 若不重写该方法，则使用Object提供的，原始方
	 * 法中返回的字符串格式：类名@地址，
	 * 通常没有什么意义。
	 */
	public String toString(){
		//  (x,y)
		return "("+x+","+y+")";
	}
	/**
	 * 当我们使用一个类的equals方法做比较时，该类
	 * 就应当重写这个方法，因为Object提供的equals
	 * 方法没有实际意义，内部就是用"=="比较的。
	 * 
	 * equals是用来比较两个对象内容是否一致，所以
	 * 比较的是两个对象的属性内容，但是不一定要求
	 * 所有属性必须完全一致，这要看将来实际开发的
	 * 需求而定。
	 * 
	 * JAVA API提供的类很多都重写了equals方法。
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Point){
			Point p = (Point)obj;
			return p.x==this.x&&p.y==this.y;
		}
		return false;
	}
	
	
}






