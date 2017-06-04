package day02;
/**
 * 
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分
 * 然后将所有拆分后的部分返回。
 * @author adminitartor
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jkl";	
		//按照数字部分拆分字符串
		String[] data = str.split("[0-9]+");
		System.out.println("len:"+data.length);		
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}
		/*
		 * 192.168.1.1
		 */
		
		
	}
}






