package day01;

public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder builder
			= new StringBuilder("a");
		
		for(int i=0;i<100000;i++){
			builder.append("a");
		}
		System.out.println(builder.toString());
	}
}
