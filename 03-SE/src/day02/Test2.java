package day02;
/**
 * 和谐用语
 * @author adminitartor
 *
 */
public class Test2 {
	public static void main(String[] args) {
		String regex 
			= "(wqnmlgdsb|nc|cnm|dsd|djb|mdzz|xbzz)";
		
		String message 
			= "wqnmlgdsb!你个xbzz!你怎么这么的nc!mdzz!你个djb!";
		
		message = message.replaceAll(regex, "****");
		System.out.println(message);
	}
}




