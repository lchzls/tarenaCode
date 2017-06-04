package day01;
/**
 * 频繁修改字符串带来的性能损耗
 * @author adminitartor
 *
 */
public class StringDemo10 {
	public static void main(String[] args) {
		String str = "a";
		for(int i=0;i<1000000;i++){
			str += "a";
		}
	}
}







