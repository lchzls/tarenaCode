package day04;
/**
 * 新循环，又称为增强for循环，for each
 * 新循环并非新的语法，是JDK1.5以后推出的一个
 * 新的特性，其是编译器认可的。
 * 作用是遍历集合或数组。
 * 
 * @author adminitartor
 *
 */
public class NewForDemo1 {
	public static void main(String[] args) {
		String[] arr = {"one","two","three","four","five"};
		for(int i=0;i<arr.length;i++){
			String str = arr[i];
			System.out.println(i+":"+str);
		}		
		
		for(String str : arr){
			System.out.println(str);
		}
	}
	
}






