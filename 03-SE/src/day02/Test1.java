package day02;
/**
 * 图片重命名练习
 * @author adminitartor
 *
 */
public class Test1 {
	public static void main(String[] args) {
		String imgName = "1.jpg";
		String[] names = imgName.split("\\.");
		System.out.println(names.length);
		
		imgName = System.currentTimeMillis()+"."+names[1];
		System.out.println(imgName);
	}
}





