package day01;
/**
 * StringBuilder是为了解决字符串频繁修改内容所导致
 * 的资源消耗问题。
 * StringBuilder内部是一个可变的字符数组，所以所有
 * 的字符串内容修改都是在这一个对象内完成，而不会因
 * 为每次的内容修改创建新对象。
 * StringBuilder提供了编辑字符串操作的相关方法，
 * 包括:增，删，改，插入
 * @author adminitartor
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "好好学习java";
		
		StringBuffer builder 
			= new StringBuffer(str);
		
		/*
		 * StringBuilder append(String str)
		 * 在当前字符串末尾追加指定内容。
		 * 
		 * 好好学习java,为了找个好工作!
		 */
		builder.append(",为了找个好工作!");
		
		str = builder.toString();
		System.out.println(str);
		
		/*
		 * StringBuilder replace(
		 * 	int start,int end,String str
		 * )
		 * 好好学习java,为了找个好工作!
		 * 好好学习java,就是为了改变世界!
		 */
		builder.replace(9, 16, "就是为了改变世界");
		System.out.println(builder.toString());
		
		/*
		 * StringBuilder delete(int start,int end)
		 * 将当前字符串中指定范围内的内容删除。
		 * 
		 * 好好学习java,就是为了改变世界!
		 * ,就是为了改变世界!
		 */
		builder.delete(0, 8);
		System.out.println(builder.toString());
		
		
		/*
		 * StringBuilder insert(int i,String str)
		 * 将给定字符串插入到指定位置处
		 * 
		 * ,就是为了改变世界!
		 * 活着,就是为了改变世界!
		 */
		builder.insert(0, "活着");
		System.out.println(builder.toString());
		
		//反转字符串
		builder.reverse();
		System.out.println(builder.toString());
	}
}








